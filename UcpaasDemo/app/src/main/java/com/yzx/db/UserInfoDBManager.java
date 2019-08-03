package com.yzx.db;

import java.util.ArrayList;
import java.util.List;
import com.yzx.db.domain.UserInfo;
import com.yzx.db.domain.UserSetting;
import com.yzx.im_demo.MainApplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
/**
 * @Title UserInfoDBManager
 * @Description 用户数据库操作
 * @Company yunzhixun
 * @author zhuqian
 * @date 2015-12-2 下午3:59:45
 */
public class UserInfoDBManager extends AbsDBManager implements
		IDBManager<UserInfo> {
	
	public static final String TAG = UserInfoDBManager.class.getSimpleName();

	private static UserInfoDBManager mInstance;

	private Object mLock = new Object();

	public static UserInfoDBManager getInstance() {
		if (mInstance == null) {
			mInstance = new UserInfoDBManager(MainApplication.getInstance());
		}
		return mInstance;
	}

	private UserInfoDBManager(Context context) {
		super(context);
	}

	@Override
	public List<UserInfo> getAll() {
		String sql = null;
		List<UserInfo> users = new ArrayList<UserInfo>();
		Cursor cursor = null;
		try {
			sql = "select * from " + DBTable.UserInfo.TABLE_NAME;
			cursor = getInstance().sqliteDB().rawQuery(sql, null);
			while (cursor.moveToNext()) {
				UserInfo user = new UserInfo();
				user.setId(cursor.getString(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_ID)));
				user.setAccount(cursor.getString(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_ACCOUNT)));
				user.setName(cursor.getString(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_NAME)));
				user.setVeriCode(cursor.getString(cursor
                        .getColumnIndex(DBTable.UserInfo.COLUMN_VERICODE)));
				user.setLoginStatus(cursor.getInt(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_LOGINSTATUS)));
				user.setDefaultLogin(cursor.getInt(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_DEFAULTLOGIN)));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
				cursor = null;
			}
		}
		return users;
	}

	@Override
	public UserInfo getById(String id) {
		return null;
	}

	@Override
	public int deleteById(String id) {
		return 0;
	}

	@Override
	public int insert(UserInfo user) {
		synchronized (mLock) {
			boolean isHave = haveUser(user);
			// 如果之前有登录或者默认登录账号，清除这两个标志
			UserInfo defaultLoginUser = getDefaultLoginUser(true);
			if(defaultLoginUser != null){
				//清空以前的登录标志
				defaultLoginUser.setLoginStatus(0);
				defaultLoginUser.setDefaultLogin(0);
				update(defaultLoginUser);
			}
			int result = 0;
			if (isHave) {
				Log.i(TAG, "db has this userInfo   --------update----------");
				return update(user);
			} else {
				ContentValues values = null;
				try {
					getInstance().sqliteDB().beginTransaction();
					values = new ContentValues();
					values.put(DBTable.UserInfo.COLUMN_ACCOUNT, user.getAccount());
					values.put(DBTable.UserInfo.COLUMN_NAME, user.getName());
					values.put(DBTable.UserInfo.COLUMN_VERICODE, user.getVeriCode());
					result = (int) getInstance().sqliteDB().insert(
							DBTable.UserInfo.TABLE_NAME, null, values);
					getInstance().sqliteDB().setTransactionSuccessful();
					Log.i(TAG, "insert db successfully id = "+user.getAccount()+",result = "+result);
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					getInstance().sqliteDB().endTransaction();
					if(values != null){
						values.clear();
						values = null;
					}
				}
			}
			return result;
		}
	}
	
	public int insert(UserInfo user,String token){
		//插入默认的设置
		int result = insert(user);
		UserSetting t = new UserSetting(user.getAccount(), 1, 1, 1, token);
		//如果没有才需要插入设置记录
		UserSetting userSetting = UserSettingsDbManager.getInstance().getById(user.getAccount());
		if(userSetting == null){
			UserSettingsDbManager.getInstance().insert(t);
		}else{
			//否则更新
			userSetting.setToken(token);
			Log.i(TAG, "---------------------更新token------------------");
			UserSettingsDbManager.getInstance().update(userSetting);
		}
		return result;
	}

	@Override
	public int update(UserInfo user) {
		if (user == null) {
			throw new IllegalArgumentException(
					"update UserInfo user == null ? ");
		}
		ContentValues values = null;
		try {
			values = new ContentValues();
			values.put(DBTable.UserInfo.COLUMN_NAME, user.getName());
			values.put(DBTable.UserInfo.COLUMN_VERICODE, user.getVeriCode());
			values.put(DBTable.UserInfo.COLUMN_LOGINSTATUS, user.getLoginStatus());
			values.put(DBTable.UserInfo.COLUMN_DEFAULTLOGIN, user.getDefaultLogin());
			Log.i(TAG, "update userinfo--------");
			return getInstance().sqliteDB().update(DBTable.UserInfo.TABLE_NAME,
					values, "_account = ?", new String[] { user.getAccount() });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 获取当前正在登录账号
	public UserInfo getCurrentLoginUser() {
		Log.i(TAG, "query login user begin----------");
		String sql = null;
		Cursor cursor = null;
		UserInfo user = null;
		try {
			sql = "select * from " + DBTable.UserInfo.TABLE_NAME
					+ " where _loginStatus = 1";
			cursor = getInstance().sqliteDB().rawQuery(sql, null);
			while (cursor != null && cursor.moveToFirst()) {
				user = new UserInfo();
				user.setId(cursor.getString(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_ID)));
				user.setAccount(cursor.getString(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_ACCOUNT)));
				user.setName(cursor.getString(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_NAME)));
				user.setVeriCode(cursor.getString(cursor
                        .getColumnIndex(DBTable.UserInfo.COLUMN_VERICODE)));
				user.setLoginStatus(cursor.getInt(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_LOGINSTATUS)));
				user.setDefaultLogin(cursor.getInt(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_DEFAULTLOGIN)));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
				cursor = null;
			}
		}
		Log.i(TAG, "query login user begin end----------"+user);
		return user;
	}

	// 获取默认登录账号
	public UserInfo getDefaultLoginUser(boolean haveLogin) {
		String sql = null;
		Cursor cursor = null;
		UserInfo user = null;
		try {
			if (haveLogin) {
				sql = "select * from " + DBTable.UserInfo.TABLE_NAME
						+ " where _defaultLogin = 1 or _loginStatus =1";
			} else {
				sql = "select * from " + DBTable.UserInfo.TABLE_NAME
						+ " where _defaultLogin = 1";
			}
			cursor = getInstance().sqliteDB().rawQuery(sql, null);
			while (cursor.moveToFirst()) {
				user = new UserInfo();
				user.setId(cursor.getString(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_ID)));
				user.setAccount(cursor.getString(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_ACCOUNT)));
				user.setName(cursor.getString(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_NAME)));
				user.setVeriCode(cursor.getString(cursor
                        .getColumnIndex(DBTable.UserInfo.COLUMN_VERICODE)));
				user.setLoginStatus(cursor.getInt(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_LOGINSTATUS)));
				user.setDefaultLogin(cursor.getInt(cursor
						.getColumnIndex(DBTable.UserInfo.COLUMN_DEFAULTLOGIN)));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
				cursor = null;
			}
		}
		return user;
	}

	/**
	 * @Description 数据库中是否有该用户
	 * @param user
	 * @return true表示有
	 * @date 2015-12-2 下午4:34:45
	 * @author zhuqian
	 * @return boolean
	 */
	public boolean haveUser(UserInfo user) {
		boolean isHave = false;
		Cursor cursor = null;
		try {
			String sql = "select * from " + DBTable.UserInfo.TABLE_NAME
					+ " where _account = '" + user.getAccount() + "'";
			cursor = getInstance().sqliteDB().rawQuery(sql, null);

			if (cursor != null && cursor.getCount() > 0) {
				isHave = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
				cursor = null;
			}
		}
		return isHave;
	}
}
