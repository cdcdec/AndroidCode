package com.yzx.db;

import com.yzx.tools.YZXContents;
import com.yzxtcp.tools.CustomLog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
/**
* @Title AbsDBManager 
* @Description 抽象的DBManager
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-2 下午2:29:11 
*/
public abstract class AbsDBManager {
	
	public static final String TAG = AbsDBManager.class.getSimpleName();
	
	private static SQLiteDatabase yzxDb;
	private static YzxDbHelper yzxDbHelper;
	
	public AbsDBManager(Context context){
		CustomLog.v("version:" + YZXContents.getVersionCode());
		openDb(context,YZXContents.getVersionCode());
	}

	private void openDb(Context context, int versionCode) {
		if(yzxDbHelper == null){
			yzxDbHelper = new YzxDbHelper(context, versionCode);
		}
		if(yzxDb == null){
			CustomLog.v("yzxDbHelper:" + yzxDbHelper);
			yzxDb = yzxDbHelper.getWritableDatabase();
		}
	}
	
	private void open(boolean isReadOnly){
		if(yzxDb == null){
			if(isReadOnly){
				yzxDb = yzxDbHelper.getReadableDatabase();
			}else{
				yzxDb = yzxDbHelper.getWritableDatabase();
			}
		}
	}
	public void destroy(){
		try {
			if(yzxDbHelper != null){
				yzxDbHelper.close();
			}
			closeDb();
		} catch (Exception e) {
			CustomLog.d(e.toString());
		}
	}
	
	public final void reopen(){
		closeDb();
		open(false);
		CustomLog.d("----reopen this db----");
	}
	private void closeDb(){
		if(yzxDb != null){
			yzxDb.close();
			yzxDb = null;
		}
	}
	
	protected final SQLiteDatabase sqliteDB(){
		open(false);
		return yzxDb;
	}

	public static class YzxDbHelper extends SQLiteOpenHelper{
		
		public static final String DATABASE_NAME = "yunzhixun.db";
		
		public YzxDbHelper(Context context,int version) {
			this(context, DATABASE_NAME, null, version);
		}
		public YzxDbHelper(Context context, String name, CursorFactory factory,
				int version) {
			super(context, name, factory, version);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			createTables(db);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		    //新的版本号来自于AndroidManifest.xml中的“versionCode”
		    if(oldVersion < 7)
	        {
	            //公众号表增加公众号服务状态字段
	            db.execSQL("alter table "+ DBTable.UserInfo.TABLE_NAME +"  add " + DBTable.UserInfo.COLUMN_VERICODE + " TEXT");
	            oldVersion++;
	        }
		}
		
		public void createTables(SQLiteDatabase db) {
			//创建用户信息表
			db.execSQL(DBTable.UserInfo.SQL_CREATE_TABLE);
			//创建用户设置表
			db.execSQL(DBTable.UserSetting.SQL_CREATE_TABLE);
			//创建会话背景表
			db.execSQL(DBTable.ConversationBg.SQL_CREATE_TABLE);
			//创建草稿表
			db.execSQL(DBTable.DraftMsg.SQL_CREATE_TABLE);
			// 创建电话消息表
			db.execSQL(DBTable.TelListsInfo.SQL_CREATE_TABLE);
			// 创建电话用户信息表
			db.execSQL(DBTable.TelUserInfo.SQL_CREATE_TABLE);
		}
		
	}
}
