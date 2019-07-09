package com.cdc.keyboard.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * .class public Lcom/laiqian/milestone/h;
 * .super Ljava/lang/Object;
 * .source "dataBaseOperator.java"
 */
public class DataBaseOperator {

    public DataBaseOperator(Context context) {


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
    public long insertData(String name, String mon, String address, String number) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mon", mon);
        contentValues.put("address", address);
        contentValues.put("number", number);
        long dataSize = db.insert("mtov", null, contentValues);
       // Log.e("--Main--", "insertData====" + name + "==" + mon + "==" + address + "==" + number);
        return dataSize;
    }

}
