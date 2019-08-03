package com.yzx.db;

import java.util.List;
import com.yzx.db.domain.UserSetting;
import com.yzx.im_demo.MainApplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;


/**
* @Title UserSettingsDbManager 
* @Description 用户设置数据库操作类
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-2 下午10:10:56 
*/
public class UserSettingsDbManager extends AbsDBManager implements IDBManager<UserSetting>{
	
	private static final String TAG = UserSettingsDbManager.class.getSimpleName();
	
	private static UserSettingsDbManager instance;
	
	public static UserSettingsDbManager getInstance(){
		if(instance == null){
			instance = new UserSettingsDbManager(MainApplication.getInstance());
		}
		return instance;
	}

	public UserSettingsDbManager(Context context) {
		super(context);
	}

	@Override
	public List<UserSetting> getAll() {
		return null;
	}

	/**
	 * 根据当前账号的设置
	 */
	public UserSetting getById(String id) {
		String sql = null;
		Cursor cursor = null;
		UserSetting setting = null;
		try {
			sql = "select * from " + DBTable.UserSetting.TABLE_NAME
					+ " where _account = "+id;
			cursor = getInstance().sqliteDB().rawQuery(sql, null);
			while (cursor.moveToFirst()) {
				setting = new UserSetting();
				setting.setId(cursor.getString(cursor.getColumnIndex(DBTable.UserSetting.COLUMN_ID)));
				setting.setAccount(cursor.getString(cursor.getColumnIndex(DBTable.UserSetting.COLUMN_ACCOUNT)));
				setting.setAsAddressAndPort(cursor.getString(cursor.getColumnIndex(DBTable.UserSetting.COLUMN_ASADDRESSANDPORT)));
				setting.setTcpAddressAndPort(cursor.getString(cursor.getColumnIndex(DBTable.UserSetting.COLUMN_TCPADDRESSANDPORT)));
				setting.setToken(cursor.getString(cursor.getColumnIndex(DBTable.UserSetting.COLUMN_TOKEN)));
				setting.setMsgNotify(cursor.getInt(cursor.getColumnIndex(DBTable.UserSetting.COLUMN_MSGNOTIFY)));
				setting.setMsgVitor(cursor.getInt(cursor.getColumnIndex(DBTable.UserSetting.COLUMN_MSGVITOR)));
				setting.setMsgVoice(cursor.getInt(cursor.getColumnIndex(DBTable.UserSetting.COLUMN_MSGVOICE)));
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
		return setting;
	}

	@Override
	public int deleteById(String id) {
		return 0;
	}

	@Override
	public int insert(UserSetting t) {
		ContentValues values = null;
		int result = 0;
		try {
			values = new ContentValues();
			values.put(DBTable.UserSetting.COLUMN_ACCOUNT, t.getAccount());
			values.put(DBTable.UserSetting.COLUMN_ASADDRESSANDPORT, t.getAsAddressAndPort());
			values.put(DBTable.UserSetting.COLUMN_TCPADDRESSANDPORT, t.getTcpAddressAndPort());
			values.put(DBTable.UserSetting.COLUMN_MSGNOTIFY, t.getMsgNotify());
			values.put(DBTable.UserSetting.COLUMN_MSGVITOR, t.getMsgVitor());
			values.put(DBTable.UserSetting.COLUMN_MSGVOICE, t.getMsgVoice());
			values.put(DBTable.UserSetting.COLUMN_TOKEN, t.getToken());
			result = (int) getInstance().sqliteDB().insert(DBTable.UserSetting.TABLE_NAME, null, values);
			Log.i(TAG, "insert successfully result = "+result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public int update(UserSetting t) {
		ContentValues values = null;
		int result = 0;
		try {
			values = new ContentValues();
			values.put(DBTable.UserSetting.COLUMN_ASADDRESSANDPORT, t.getAsAddressAndPort());
			values.put(DBTable.UserSetting.COLUMN_TCPADDRESSANDPORT, t.getTcpAddressAndPort());
			values.put(DBTable.UserSetting.COLUMN_MSGNOTIFY, t.getMsgNotify());
			values.put(DBTable.UserSetting.COLUMN_MSGVITOR, t.getMsgVitor());
			values.put(DBTable.UserSetting.COLUMN_MSGVOICE, t.getMsgVoice());
			values.put(DBTable.UserSetting.COLUMN_TOKEN, t.getToken());
			result = (int) getInstance().sqliteDB().update(DBTable.UserSetting.TABLE_NAME, values, "_account = ?", new String[]{t.getAccount()});
			Log.i(TAG, "update successfully result = "+result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		notify(t.getId());
		DBObserver.getInstance().notifyObserver(t.getId());
		return result;
	}
}
