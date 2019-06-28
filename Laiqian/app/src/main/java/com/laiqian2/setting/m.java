package com.laiqian.setting;

import android.content.Context;
import android.database.Cursor;
import com.laiqian.milestone.h;
import java.text.SimpleDateFormat;
import java.util.Date;

public class m {
  public static void a(Context paramContext, String paramString, long paramLong) {
    h h = new h(paramContext);
    String str = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    h.t(stringBuilder.toString(), paramString, str);
    h.close();
  }
  
  private static void c(Context paramContext, String paramString1, String paramString2, String paramString3) {
    h h = new h(paramContext);
    h.u(paramString1, paramString2, paramString3);
    h.close();
  }
  
  public static void i(Context paramContext, String paramString1, String paramString2) {
    h h = new h(paramContext);
    h.ab(paramString1, paramString2);
    h.close();
  }
  
  public static String s(Context paramContext, String paramString) {
    String str2 = "";
    t(paramContext, paramString);
    h h = new h(paramContext);
    Cursor cursor = h.gR(paramString);
    String str1 = str2;
    if (cursor.moveToFirst()) {
      str1 = cursor.getString(cursor.getColumnIndex("sBusinessType"));
      str2 = cursor.getString(cursor.getColumnIndex("nDateTime"));
      StringBuilder stringBuilder1 = cursor.getString(cursor.getColumnIndex("sPersonNameShort"));
      long l = cursor.getLong(cursor.getColumnIndex("nNumber")) + 1L;
      if (stringBuilder1.equals("") || stringBuilder1 == "") {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append("-");
        stringBuilder1.append(str2);
        stringBuilder1.append("-");
        stringBuilder1.append(l);
        str1 = stringBuilder1.toString();
        cursor.close();
        h.close();
        return str1;
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append("-");
      stringBuilder2.append(str2);
      stringBuilder2.append("-");
      stringBuilder2.append(stringBuilder1);
      stringBuilder2.append("-");
      stringBuilder2.append(l);
      str1 = stringBuilder2.toString();
    } 
    cursor.close();
    h.close();
    return str1;
  }
  
  private static void t(Context paramContext, String paramString) {
    h h = new h(paramContext);
    Cursor cursor = h.gR(paramString);
    if (cursor != null && cursor.moveToFirst()) {
      String str1 = cursor.getString(cursor.getColumnIndex("nDateTime"));
      String str2 = cursor.getString(cursor.getColumnIndex("sPersonNameShort"));
      cursor.getString(cursor.getColumnIndex("nNumber"));
      if (str2 == null) {
        str2 = paramContext.getSharedPreferences("settings", 0).getString("user_phone", "");
        i(paramContext, paramString, str2.substring(str2.length() - 4, str2.length()));
      } 
      str2 = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
      if (!str2.equals(str1))
        c(paramContext, paramString, str2, "0"); 
    } 
    cursor.close();
    h.close();
  }
  
  public static long u(Context paramContext, String paramString) {
    long l;
    h h = new h(paramContext);
    Cursor cursor = h.gR(paramString);
    if (cursor != null && cursor.moveToFirst()) {
      l = cursor.getLong(cursor.getColumnIndex("nNumber"));
    } else {
      l = 0L;
    } 
    cursor.close();
    h.close();
    return l;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */