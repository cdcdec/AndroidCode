package com.laiqian.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import com.google.a.a.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ab {
  private static List<String> a(String paramString, Cursor paramCursor) {
    ArrayList arrayList = new ArrayList();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("[");
    stringBuilder2.append(paramString);
    stringBuilder2.append("]");
    arrayList.add(stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("    ");
    stringBuilder1.append(by.join("|", paramCursor.getColumnNames()));
    arrayList.add(stringBuilder1.toString());
    arrayList.addAll(e(paramCursor));
    return arrayList;
  }
  
  public static ArrayList<HashMap<String, Object>> d(@NonNull Cursor paramCursor) {
    ArrayList arrayList = new ArrayList();
    while (paramCursor.moveToNext()) {
      HashMap hashMap = new HashMap();
      for (byte b = 0; b < paramCursor.getColumnCount(); b++) {
        String str = paramCursor.getColumnName(b);
        switch (paramCursor.getType(b)) {
          default:
            hashMap.put(str, paramCursor.getString(b));
            break;
          case 2:
            hashMap.put(str, Double.valueOf(paramCursor.getDouble(b)));
            break;
          case 1:
            if (str.equals("nOrderType")) {
              hashMap.put(str, Integer.valueOf(paramCursor.getInt(b)));
              break;
            } 
            hashMap.put(str, Long.valueOf(paramCursor.getLong(b)));
            break;
          case 0:
            break;
        } 
      } 
      arrayList.add(hashMap);
    } 
    return arrayList;
  }
  
  private static List<String> e(Cursor paramCursor) {
    ArrayList arrayList = new ArrayList();
    while (paramCursor.moveToNext()) {
      int i = paramCursor.getColumnCount();
      ArrayList arrayList1 = new ArrayList();
      for (byte b = 0; b < i; b++) {
        String str = paramCursor.getString(b);
        if (str == null) {
          arrayList1.add("NIL");
        } else {
          arrayList1.add(str);
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("    ");
      stringBuilder.append(by.a("|", arrayList1));
      arrayList.add(stringBuilder.toString());
    } 
    return arrayList;
  }
  
  public static String[] f(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    cursor2 = null;
    Cursor cursor3 = null;
    SQLiteDatabase sQLiteDatabase = null;
    Cursor cursor1 = cursor2;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      cursor1 = cursor2;
      stringBuilder.append("PRAGMA table_info(");
      cursor1 = cursor2;
      stringBuilder.append(paramString);
      cursor1 = cursor2;
      stringBuilder.append(")");
      cursor1 = cursor2;
      cursor2 = paramSQLiteDatabase.rawQuery(stringBuilder.toString(), null);
      paramSQLiteDatabase = sQLiteDatabase;
      if (cursor2 != null)
        try {
          i = cursor2.getColumnIndex("name");
          if (-1 == i)
            return null; 
          b = 0;
          arrayOfString = new String[cursor2.getCount()];
        } catch (Exception paramSQLiteDatabase) {
        
        } finally {
          paramSQLiteDatabase = null;
        }  
      SQLiteDatabase sQLiteDatabase1 = paramSQLiteDatabase;
      if (cursor2 != null) {
        cursor2.close();
        return paramSQLiteDatabase;
      } 
    } catch (Exception paramSQLiteDatabase) {
      paramString = null;
      cursor2 = cursor3;
      cursor1 = cursor2;
      a.e(paramSQLiteDatabase);
      if (cursor2 != null)
        cursor2.close(); 
    } finally {}
    return paramString;
  }
  
  public static int k(SQLiteDatabase paramSQLiteDatabase) {
    Cursor cursor = paramSQLiteDatabase.rawQuery("SELECT changes()", null);
    cursor.moveToFirst();
    int i = cursor.getInt(0);
    cursor.close();
    return i;
  }
  
  public static List<String> l(SQLiteDatabase paramSQLiteDatabase) {
    ArrayList arrayList = new ArrayList();
    Cursor cursor = paramSQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type = 'table'", null);
    while (cursor.moveToNext())
      arrayList.add(cursor.getString(0)); 
    cursor.close();
    return arrayList;
  }
  
  public static List<String> m(SQLiteDatabase paramSQLiteDatabase) {
    List list = l(paramSQLiteDatabase);
    list.remove("android_metadata");
    list.remove("ts_table_profile");
    return list;
  }
  
  public static List<String> n(SQLiteDatabase paramSQLiteDatabase) {
    ArrayList arrayList = new ArrayList();
    for (String str : l(paramSQLiteDatabase)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SELECT * FROM ");
      stringBuilder.append(str);
      Cursor cursor1 = paramSQLiteDatabase.rawQuery(stringBuilder.toString(), null);
      arrayList.addAll(a(str, cursor1));
      cursor1.close();
    } 
    Cursor cursor = paramSQLiteDatabase.rawQuery("SELECT total_changes()", null);
    arrayList.addAll(a("total_changes", cursor));
    cursor.close();
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */