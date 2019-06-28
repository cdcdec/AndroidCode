package com.laiqian.print.type;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.u;
import com.laiqian.print.model.type.usb.d;

public class a {
  private static a cJO;
  
  private Context mContext;
  
  private a(Context paramContext) { this.mContext = paramContext; }
  
  public static a bh(Context paramContext) {
    if (cJO == null)
      cJO = new a(paramContext.getApplicationContext()); 
    return cJO;
  }
  
  public boolean b(d paramd) {
    try {
      exception = new u(this.mContext);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    boolean bool = exception.a(paramd);
    exception.close();
    return bool;
  }
  
  public d lG(String paramString) {
    String str = null;
    try {
      exception = new u(this.mContext);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    Cursor cursor = exception.hy(paramString);
    d d = str;
    if (cursor != null) {
      d = str;
      if (cursor.moveToFirst()) {
        d = cursor.getString(cursor.getColumnIndex("sFieldName"));
        str = cursor.getString(cursor.getColumnIndex("sSpareField1"));
        boolean bool = "58".equals(str);
        byte b1 = 40;
        byte b2 = 0;
        if (bool) {
          b1 = 58;
        } else if ("80".equals(str)) {
          b1 = 80;
        } else if ("40,30".equals(str)) {
          b2 = 30;
        } else if ("60,40".equals(str)) {
          b1 = 60;
          b2 = 40;
        } else {
          b1 = 0;
        } 
        d = new d(paramString, d);
        d.setWidth(b1);
        d.setHeight(b2);
      } 
    } 
    if (cursor != null)
      cursor.close(); 
    exception.close();
    return d;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */