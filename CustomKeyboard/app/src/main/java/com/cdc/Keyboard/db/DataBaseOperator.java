package com.cdc.keyboard.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.cdc.keyboard.basic.RootApplication;
import com.cdc.keyboard.util.ChuanBeiUtil;

import java.security.NoSuchAlgorithmException;

/**
 * .class public Lcom/laiqian/milestone/h;
 * .super Ljava/lang/Object;
 * .source "dataBaseOperator.java"
 */
public class DataBaseOperator {


    private SQLiteDatabase sqLiteDatabase;

    public DataBaseOperator(Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();

    }

   /* public Cursor aO(long paramLong) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT [T_USER].[_id] as _id,[T_STRING].[sFieldName] as sUserStatus,  [T_ROLE].[sRoleName] as sUserRole,  [T_ROLE].[_id] as nUserRole,  [T_USER].[nDeletionFlag] as nDeletionFlag,  [T_USER].[sUserPassword] as sUserPassword,  case   when [T_USER].[nDeletionFlag]==170001 then (select sFieldName from T_String where _id=170001 and sText like 'zh') when [T_USER].[nDeletionFlag]==170002 then (select sFieldName from T_String where _id=170002 and sText like 'zh') end 'sDeletionFlag',  [T_USER].[nShopID] as sShopName,  [T_USER].[sUserName] as sUserName,   [T_USER].[sUserPhone] as sUserPhone  FROM [T_USER]  INNER JOIN [T_STRING] ON [T_USER].[nUserStatus] = [T_STRING].[_id] and [T_STRING].[sText] like '");
        stringBuilder.append(this.bJA);
        stringBuilder.append("' INNER JOIN [T_ROLE] ON [T_USER].[nUserRole] = [T_ROLE].[_id]  where [T_USER].[nShopID]=");
        stringBuilder.append(paramLong);
        stringBuilder.append(" and nDeletionFlag != 170003 order by nDeletionFlag desc,[T_USER].[nDateTime] desc ;");
        String str = stringBuilder.toString();
        return this.bJQ.rawQuery(str, null);
    }
*/

    /**
     * 添加数据
     * bsid 添加的数据ID
     * name 添加数据名称
     */
    public long insertData(String sUserName, String sUserPhone, String sUserPassword) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", sUserPhone);
        contentValues.put("sUserName", sUserName);
        contentValues.put("sUserPhone", sUserPhone);
        contentValues.put("sUserPassword", sUserPassword);
        long dataSize = 0l;
        try {
            dataSize = sqLiteDatabase.insert("T_USER", null, contentValues);
        } catch (Exception e) {
            Log.e("123", "数据插入错误");
        }
        // Log.e("--Main--", "insertData====" + name + "==" + mon + "==" + address + "==" + number);
        return dataSize;
    }

    public long[] checkUserPassWord(String userPhone, String userPassWord) {
        long[] arrayOfLong = new long[2];
        arrayOfLong[0] = -1L;
        arrayOfLong[1] = -1L;
        String str = "";
        if (userPassWord.length() == 32) {
            str = userPassWord;
        } else {
            String str1 = ChuanBeiUtil.change(userPassWord);
            str = str1;
        }
        Cursor cursor = RootApplication.getDataBaseOperator().sqLiteDatabase.rawQuery("select _id, nShopID, nDeletionFlag from T_USER where ((sUserPhone=? and sUserPassword=?) or (sUserPhone=? and sUserPassword=?)) ", new String[]{userPhone, userPassWord, userPhone, str});

        if (cursor != null) {
            arrayOfLong[0] = cursor.getCount();
            Log.e("123",cursor.getCount()+"==1");
//            Log.e("123",cursor.getColumnIndex("_id")+"==2");
//
//            int idValue=cursor.getInt(cursor.getColumnIndex("_id"));
//            Log.e("123",idValue+"");
            cursor.close();
        }
        return arrayOfLong;
    }


}
