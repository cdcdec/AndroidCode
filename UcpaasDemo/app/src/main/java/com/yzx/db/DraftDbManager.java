package com.yzx.db;

import java.util.List;
import com.yzx.db.domain.DraftMsg;
import com.yzx.im_demo.MainApplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
/**
* @Title DraftDbManager 
* @Description 草稿数据库操作类
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-2 下午10:11:34 
*/
public class DraftDbManager extends AbsDBManager implements IDBManager<DraftMsg>{
	
	private static final String TAG = DraftDbManager.class.getSimpleName();
	
	private static DraftDbManager instance;
	
	public static DraftDbManager getInstance(){
		if(instance == null){
			instance = new DraftDbManager(MainApplication.getInstance());
		}
		return instance;
	}

	public DraftDbManager(Context context) {
		super(context);
	}

	@Override
	public List<DraftMsg> getAll() {
		return null;
	}

	@Override
	public DraftMsg getById(String id) {
		return null;
	}
	/**
	* @Description 根据会话id找到草稿
	* @param targetId
	* @return	TODO
	* @date 2015-12-2 下午10:15:09 
	* @author zhuqian  
	* @return DraftMsg
	 */
	public DraftMsg getByTargetId(String targetId){
		String account = UserInfoDBManager.getInstance().getCurrentLoginUser().getAccount();
		String sql = null;
		Cursor cursor = null;
		DraftMsg draftMsg = null;
		try {
			sql = "select * from " + DBTable.DraftMsg.TABLE_NAME
					+ " where _account = "+account+" and _targetId = "+"'"+targetId+"'";
			cursor = getInstance().sqliteDB().rawQuery(sql, null);
			while (cursor.moveToFirst()) {
				draftMsg = new DraftMsg();
				draftMsg.setId(cursor.getString(cursor.getColumnIndex(DBTable.DraftMsg.COLUMN_ID)));
				draftMsg.setAccount(cursor.getString(cursor.getColumnIndex(DBTable.DraftMsg.COLUMN_ACCOUNT)));
				draftMsg.setTargetId(cursor.getString(cursor.getColumnIndex(DBTable.DraftMsg.COLUMN_TARGETID)));
				draftMsg.setDraftMsg(cursor.getString(cursor.getColumnIndex(DBTable.DraftMsg.COLUMN_DRAFTMSG)));
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
		return draftMsg;
	}

	@Override
	public int deleteById(String id) {
		return 0;
	}

	@Override
	public int insert(DraftMsg t) {
		ContentValues values = null;
		if(getByTargetId(t.getTargetId()) != null){
			return update(t);
		}
		int result = 0;
		try {
			values = new ContentValues();
			values.put(DBTable.DraftMsg.COLUMN_ACCOUNT, t.getAccount());
			values.put(DBTable.DraftMsg.COLUMN_TARGETID, t.getTargetId());
			values.put(DBTable.DraftMsg.COLUMN_DRAFTMSG, t.getDraftMsg());
			result = (int) getInstance().sqliteDB().insert(DBTable.DraftMsg.TABLE_NAME, null, values);
			Log.i(TAG, "insert successfully result = "+result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public int update(DraftMsg d) {
		ContentValues values = null;
		int result = 0;
		try {
			values = new ContentValues();
			values.put(DBTable.DraftMsg.COLUMN_DRAFTMSG, d.getDraftMsg());
			result = (int) getInstance().sqliteDB().update(DBTable.DraftMsg.TABLE_NAME, values, "_account = ? and _targetId = ?", new String[]{d.getAccount(),d.getTargetId()});
			Log.i(TAG, "update successfully result = "+result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

}
