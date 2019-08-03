package com.yzx.db;  

import java.util.ArrayList;
import java.util.List;

import com.yzx.db.domain.TelUsersInfo;
import com.yzx.im_demo.MainApplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**  
 * @Title TelUserInfoDBManager   
 * @Description  音视频电话个人信息数据库操作类
 * @Company yunzhixun  
 * @author xhb
 * @date 2015-12-14 下午3:10:13  
 */
public class TelUserInfoDBManager extends AbsDBManager implements IDBManager<TelUsersInfo>{
	private static TelUserInfoDBManager telephoneUserInfoDBManager;
	private TelUserInfoDBManager(Context context) { 
		super(context);  
	}

	public static TelUserInfoDBManager getInstance() {
		if(telephoneUserInfoDBManager == null) {
			telephoneUserInfoDBManager = new TelUserInfoDBManager(MainApplication.getInstance());
		}
		return telephoneUserInfoDBManager;
	}
	
	@Override
	public List<TelUsersInfo> getAll() {
		List<TelUsersInfo> users = new ArrayList<TelUsersInfo>();
		Cursor cursor = null;
		try {
			String sql = "select * from " + DBTable.TelUserInfo.TABLE_NAME;
			cursor = getInstance().sqliteDB().rawQuery(sql, null);
			while (cursor.moveToNext()) {
				TelUsersInfo user = new TelUsersInfo();
				user.setId(cursor.getInt(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_ID)));
				user.setGravator(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_GRAVATOR)));
				user.setName(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_NAME)));
				user.setTelephone(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_TELEPHONE)));
				user.setDialFlag(cursor.getInt(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_DIALFLAG)));
				user.setTime(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_TIME)));
				user.setTelMode(cursor.getInt(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_TELMODE))); 
				user.setDialMessage(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_DIALMESSAGE))); 
				user.setLoginPhone(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_LOGINPHONE))); 
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(cursor != null) {
				cursor.close();
				cursor = null;
			}
		}
		return users;
	}

	public List<TelUsersInfo> getAll(String telPhone, String loginPhone) {
		List<TelUsersInfo> users = new ArrayList<TelUsersInfo>();
		Cursor cursor = null;
		try {
			String sql = "select * from " + DBTable.TelUserInfo.TABLE_NAME + " where _telephone=? and _loginphone=? order by " + DBTable.TelUserInfo.COLUMN_ID + " DESC";
			cursor = getInstance().sqliteDB().rawQuery(sql, new String[]{telPhone,loginPhone}); 
			while (cursor.moveToNext()) {
				TelUsersInfo user = new TelUsersInfo();
				user.setId(cursor.getInt(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_ID)));
				user.setGravator(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_GRAVATOR)));
				user.setName(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_NAME)));
				user.setTelephone(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_TELEPHONE)));
				user.setDialFlag(cursor.getInt(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_DIALFLAG)));
				user.setTime(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_TIME)));
				user.setTelMode(cursor.getInt(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_TELMODE))); 
				user.setDialMessage(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_DIALMESSAGE))); 
				user.setLoginPhone(cursor.getString(cursor.getColumnIndex(DBTable.TelUserInfo.COLUMN_LOGINPHONE)));
				users.add(user); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(cursor != null) {
				cursor.close();
				cursor = null;
			}
		}
		return users;
	}
	
	@Override
	public TelUsersInfo getById(String id) {
		  
		// TODO Auto-generated method stub  
		return null;
	}

	@Override
	public int deleteById(String id) {
		return getInstance().sqliteDB().delete(DBTable.TelUserInfo.TABLE_NAME,
				"_telephone=?",new String[]{id});
	}

	@Override
	public int insert(TelUsersInfo t) {
		// 先从数据库中查询通话记录，获取出查询通话记录的昵称，查看下是否跟插入的昵称一致，如果不一致，则更新昵称
		List<TelUsersInfo> queryUsers = getAll(t.getLoginPhone(), t.getTelephone());
		if(queryUsers != null && queryUsers.size() > 0) {
			for (TelUsersInfo telUsersInfo : queryUsers) {
				if(!t.getName().equals(telUsersInfo.getName())) {
					// 更新这个人的昵称
					update(t);
				}
			}
		}
		ContentValues values = null;
		int result = 0;
		try {
			values = new ContentValues();
			values.put(DBTable.TelUserInfo.COLUMN_GRAVATOR, t.getGravator());
			values.put(DBTable.TelUserInfo.COLUMN_NAME, t.getName());
			values.put(DBTable.TelUserInfo.COLUMN_TELEPHONE, t.getTelephone());
			values.put(DBTable.TelUserInfo.COLUMN_DIALFLAG, t.getDialFlag());
			values.put(DBTable.TelUserInfo.COLUMN_TIME, t.getTime());
			values.put(DBTable.TelUserInfo.COLUMN_TELMODE, t.getTelMode());
			values.put(DBTable.TelUserInfo.COLUMN_DIALMESSAGE, t.getDialMessage());
			values.put(DBTable.TelUserInfo.COLUMN_LOGINPHONE, t.getLoginPhone());
			result = (int) sqliteDB().insert(DBTable.TelUserInfo.TABLE_NAME, null, values);
			
			//如果记录多于100条，则删除较早的
			List<TelUsersInfo> users = getAll(t.getTelephone(), t.getLoginPhone());
			if (users.size() > 100) {
			    int id = users.get(users.size() - 1).getId();
                sqliteDB().delete(DBTable.TelUserInfo.TABLE_NAME, DBTable.TelUserInfo.COLUMN_ID + "=?", new String[] {id + ""});
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(values != null ) {
				values.clear();
				values = null;
			}
		}
		return result;
	}

	@Override
	public int update(TelUsersInfo t) {
		int result = -1;
		ContentValues values = new ContentValues();
		values.put(DBTable.TelUserInfo.COLUMN_NAME, t.getName());
		result =sqliteDB().update(DBTable.TelUserInfo.TABLE_NAME, values, "_telephone=? and _loginphone=?" , new String[] {t.getTelephone(), t.getLoginPhone()});
		return result;
	}

}
  
