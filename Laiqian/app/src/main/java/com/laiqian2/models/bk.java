package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;

public class bk extends bj {
  public bk(Context paramContext) { super(paramContext); }
  
  public String WN() {
    c(WM(), new String[] { VC(), getUserID() });
    Cursor cursor = VM();
    String str1;
    for (str1 = ""; cursor.moveToNext(); str1 = stringBuilder.toString()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(cursor.getString(cursor.getColumnIndex("nSelectedWarehouseID")));
      stringBuilder.append(",");
    } 
    cursor.close();
    String str2 = str1;
    if (!"".equals(str1))
      str2 = str1.substring(0, str1.length() - 1); 
    return str2;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */