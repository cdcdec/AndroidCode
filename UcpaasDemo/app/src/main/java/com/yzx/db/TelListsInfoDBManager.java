package com.yzx.db;  

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.yzx.db.domain.TelListsInfo;
import com.yzx.im_demo.MainApplication;
import com.yzxtcp.tools.CustomLog;

/**  
 * @Title TelListsInfoDBManager   
 * @Description  电话列表信息表数据库操作类
 * @Company yunzhixun  
 * @author xhb
 * @date 2015-12-14 上午10:08:15  
 */
public class TelListsInfoDBManager extends AbsDBManager implements IDBManager<TelListsInfo>{
	private static TelListsInfoDBManager instance;
	public static final String TAG = TelListsInfoDBManager.class.getSimpleName();

	private TelListsInfoDBManager(Context context) {
		super(context);  
	}

	public static TelListsInfoDBManager getInstance() {
		if(instance == null) { 
			CustomLog.v("MainAppliction:" + MainApplication.getInstance());
			instance = new TelListsInfoDBManager(MainApplication.getInstance());
		}
		return instance;
	}
	
	@Override
	public List<TelListsInfo> getAll() {
		List<TelListsInfo> users = new ArrayList<TelListsInfo>();
		Cursor cursor = null;
		try {
			String sql = "select * from " + DBTable.TelListsInfo.TABLE_NAME;
			cursor = getInstance().sqliteDB().rawQuery(sql, null);
			while (cursor.moveToNext()) {
				TelListsInfo user = new TelListsInfo();
				user.setId(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_ID)));
				user.setGravator(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_GRAVATOR)));
				user.setDialFlag(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_DIALFLAG)));
				user.setName(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_NAME)));
				user.setTelMode(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_TELMODE)));
				user.setTime(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_TIME)));
				user.setTelephone(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_TELEPHONE)));
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
	
	public List<TelListsInfo> getAll(String loginPhone) {
		//置顶用户
		List<TelListsInfo> isTopUsers = new ArrayList<TelListsInfo>();
		//非置顶用户
		List<TelListsInfo> isNoTopUsers = new ArrayList<TelListsInfo>();
		Cursor cursor = null;
		try {
			String isTopSql = "select * from " + DBTable.TelListsInfo.TABLE_NAME + " where _loginphone=? and _istop = 1 order by " + DBTable.TelListsInfo.COLUMN_TIME + " DESC";
			cursor = getInstance().sqliteDB().rawQuery(isTopSql, new String[] {loginPhone});
			while (cursor.moveToNext()) {
				TelListsInfo user = new TelListsInfo();
				user.setId(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_ID)));
				user.setGravator(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_GRAVATOR)));
				user.setDialFlag(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_DIALFLAG)));
				user.setName(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_NAME)));
				user.setTelMode(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_TELMODE)));
				user.setTime(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_TIME)));
				user.setTelephone(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_TELEPHONE)));
				user.setLoginPhone(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_LOGINPHONE))); 
				user.setIsTop(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_ISTOP)));
				isTopUsers.add(user); 
			}
			cursor.close();
			cursor = null;
			String isNoTopSql = "select * from " + DBTable.TelListsInfo.TABLE_NAME + " where _loginphone=? and _istop = 0 order by " + DBTable.TelListsInfo.COLUMN_TIME + " DESC";
			cursor = getInstance().sqliteDB().rawQuery(isNoTopSql, new String[] {loginPhone});
			while (cursor.moveToNext()) {
				TelListsInfo user = new TelListsInfo();
				user.setId(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_ID)));
				user.setGravator(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_GRAVATOR)));
				user.setDialFlag(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_DIALFLAG)));
				user.setName(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_NAME)));
				user.setTelMode(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_TELMODE)));
				user.setTime(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_TIME)));
				user.setTelephone(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_TELEPHONE)));
				user.setLoginPhone(cursor.getString(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_LOGINPHONE))); 
				user.setIsTop(cursor.getInt(cursor.getColumnIndex(DBTable.TelListsInfo.COLUMN_ISTOP)));
				isNoTopUsers.add(user); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(cursor != null) {
				cursor.close();
				cursor = null;
			}
		}
		List<TelListsInfo> users = new ArrayList<TelListsInfo>();
		users.addAll(isTopUsers);
		users.addAll(isNoTopUsers);
		return users;
	}


	@Override
	public TelListsInfo getById(String id) {
		return null;
	}

	/**
	 * 删除电话记录
	 * @return
	 */
	public int deleteTelListInfo(TelListsInfo info){
		return sqliteDB().delete(DBTable.TelListsInfo.TABLE_NAME, DBTable.TelListsInfo.COLUMN_ID + " = ?", new String[] {info.getId()+""});
	}
	@Override
	public int deleteById(String telPhone) {
		int result = sqliteDB().delete(DBTable.TelListsInfo.TABLE_NAME, "_TELEPHONE=?", new String[] {telPhone});
		return result;
	}

	@Override
	public int insert(TelListsInfo t) {
		if(isTop(t.getTelephone())){
			Log.i(TAG, "this TelListsInfo is top");
			t.setIsTop(1);
		}else{
			Log.i(TAG, "this TelListsInfo is not top");
			t.setIsTop(0);
		}
		deleteById(t.getTelephone());
		ContentValues values = null;
		int result = 0;
		try {
			values = new ContentValues();
			values.put(DBTable.TelListsInfo.COLUMN_GRAVATOR, t.getGravator());
			values.put(DBTable.TelListsInfo.COLUMN_NAME, t.getName());
			values.put(DBTable.TelListsInfo.COLUMN_TELMODE, t.getTelMode());
			values.put(DBTable.TelListsInfo.COLUMN_DIALFLAG, t.getDialFlag());
			values.put(DBTable.TelListsInfo.COLUMN_TIME, t.getTime());
			values.put(DBTable.TelListsInfo.COLUMN_TELEPHONE, t.getTelephone());
			values.put(DBTable.TelListsInfo.COLUMN_LOGINPHONE, t.getLoginPhone());
			values.put(DBTable.TelListsInfo.COLUMN_ISTOP, t.getIsTop());
			result = (int) sqliteDB().insert(DBTable.TelListsInfo.TABLE_NAME, null, values);
			
			//如果记录多于100条，则删除较早的
			List<TelListsInfo> users = getAll(t.getLoginPhone());
			if (users.size() > 100) {
			    int id = users.get(users.size() - 1).getId();
			    sqliteDB().delete(DBTable.TelListsInfo.TABLE_NAME, DBTable.TelListsInfo.COLUMN_ID + "=?", new String[] {id + ""});
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
	public int update(TelListsInfo t) {
		if (t == null) {
			throw new IllegalArgumentException(
					"update TelListsInfo t == null ? ");
		}
		ContentValues values = null;
		try {
			values = new ContentValues();
			values.put(DBTable.TelListsInfo.COLUMN_GRAVATOR, t.getGravator());
			values.put(DBTable.TelListsInfo.COLUMN_NAME, t.getName());
			values.put(DBTable.TelListsInfo.COLUMN_TELMODE, t.getTelMode());
			values.put(DBTable.TelListsInfo.COLUMN_DIALFLAG, t.getDialFlag());
			values.put(DBTable.TelListsInfo.COLUMN_TIME, t.getTime());
			values.put(DBTable.TelListsInfo.COLUMN_TELEPHONE, t.getTelephone());
			values.put(DBTable.TelListsInfo.COLUMN_LOGINPHONE, t.getLoginPhone());
			values.put(DBTable.TelListsInfo.COLUMN_ISTOP, t.getIsTop());
			Log.i(TAG, "update TelListsInfo--------");
			return getInstance().sqliteDB().update(DBTable.TelListsInfo.TABLE_NAME,
					values, "_loginphone = ? and _id = ?", new String[] { t.getLoginPhone(),t.getId()+""});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 判断某个号码是否是置顶
	 * @param phone
	 * @return
	 */
	private boolean isTop(String phone){
		Cursor cursor = null;
		try {
			String isTopSql = "select * from " + DBTable.TelListsInfo.TABLE_NAME + " where _telephone=? and _istop = 1";
			cursor = getInstance().sqliteDB().rawQuery(isTopSql, new String[] {phone});
			if(cursor.getCount() > 0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(cursor != null) {
				cursor.close();
				cursor = null;
			}
		}
		
		return false;
	}

}
  
