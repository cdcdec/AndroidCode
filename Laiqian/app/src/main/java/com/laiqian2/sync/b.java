package com.laiqian.sync;

import android.database.sqlite.SQLiteDatabase;

public class b {
  public static void a(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString1, String paramString2) {
    if (paramInt == 1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("UPDATE ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" SET nIsUpdated = 2  WHERE _id IN (");
      stringBuilder1.append(paramString2);
      stringBuilder1.append(")");
      paramSQLiteDatabase.execSQL(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UPDATE ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" SET nIsUpdated = 2  WHERE _id IN (");
    stringBuilder.append(paramString2);
    stringBuilder.append(")");
    paramSQLiteDatabase.execSQL(stringBuilder.toString());
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString1, String paramString2, boolean paramBoolean) {
    if (!paramBoolean) {
      if (paramInt == 1) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("UPDATE ");
        stringBuilder2.append(paramString1);
        stringBuilder2.append(" SET nIsUpdated = 1, nUpdateFlag = 1 WHERE _id IN (");
        stringBuilder2.append(paramString2);
        stringBuilder2.append(")");
        paramSQLiteDatabase.execSQL(stringBuilder2.toString());
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("UPDATE ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" SET nIsUpdated = 1, nUpdateFlag = CASE WHEN nUpdateFlag is null THEN 1 WHEN nUpdateFlag = 0 THEN 1 WHEN nUpdateFlag >= 1 THEN nUpdateFlag END WHERE _id IN (");
      stringBuilder1.append(paramString2);
      stringBuilder1.append(")");
      paramSQLiteDatabase.execSQL(stringBuilder1.toString());
      return;
    } 
    if (paramInt == 1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("UPDATE ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" SET nIsUpdated = 1, nUpdateFlag = 1 WHERE _id IN (");
      stringBuilder1.append(paramString2);
      stringBuilder1.append(") AND nIsUpdated = 2");
      paramSQLiteDatabase.execSQL(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UPDATE ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" SET nIsUpdated = 1, nUpdateFlag = CASE WHEN nUpdateFlag is null THEN 1 WHEN nUpdateFlag = 0 THEN 1 WHEN nUpdateFlag >= 1 THEN nUpdateFlag END WHERE _id IN (");
    stringBuilder.append(paramString2);
    stringBuilder.append(") AND nIsUpdated = 2");
    paramSQLiteDatabase.execSQL(stringBuilder.toString());
  }
  
  public static void b(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString1, String paramString2, boolean paramBoolean) {
    if (!paramBoolean) {
      if (paramInt == 1) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("UPDATE ");
        stringBuilder2.append(paramString1);
        stringBuilder2.append(" SET nIsUpdated = 0,  nUpdateFlag = (CASE WHEN nUpdateFlag == 1 THEN 2 ELSE nUpdateFlag END) WHERE _id IN (");
        stringBuilder2.append(paramString2);
        stringBuilder2.append(")");
        paramSQLiteDatabase.execSQL(stringBuilder2.toString());
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("UPDATE ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" SET nIsUpdated = 0,   nUpdateFlag = (CASE WHEN nUpdateFlag == 1 THEN 2 ELSE nUpdateFlag END)  WHERE _id IN (");
      stringBuilder1.append(paramString2);
      stringBuilder1.append(")");
      paramSQLiteDatabase.execSQL(stringBuilder1.toString());
      return;
    } 
    if (paramInt == 1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("UPDATE ");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" SET nIsUpdated = 0,  nUpdateFlag = (CASE WHEN nUpdateFlag == 1 THEN 2 ELSE nUpdateFlag END)  WHERE _id IN (");
      stringBuilder1.append(paramString2);
      stringBuilder1.append(") AND nIsUpdated = 2");
      paramSQLiteDatabase.execSQL(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UPDATE ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" SET nIsUpdated = 0,  nUpdateFlag = (CASE WHEN nUpdateFlag == 1 THEN 2 ELSE nUpdateFlag END)  WHERE _id IN (");
    stringBuilder.append(paramString2);
    stringBuilder.append(") AND nIsUpdated = 2");
    paramSQLiteDatabase.execSQL(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */