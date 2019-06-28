package com.laiqian.dcb.api.b;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

public class d {
  public static boolean aPU = false;
  
  static  {
  
  }
  
  public static void an(Object paramObject) { e("_LQK", paramObject); }
  
  public static void ao(Object paramObject) { f("_LQK", paramObject); }
  
  public static void e(String paramString, Object paramObject) {
    if (aPU) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramObject);
      stringBuilder.append("      {");
      stringBuilder.append(paramString);
      stringBuilder.append("}. The time is: ");
      stringBuilder.append((new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss")).format(new Date()));
      Log.e(paramString, stringBuilder.toString());
    } 
  }
  
  public static void f(String paramString, Object paramObject) {
    if (aPU) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramObject);
      stringBuilder.append("      {");
      stringBuilder.append(paramString);
      stringBuilder.append("}. The time is: ");
      stringBuilder.append((new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss")).format(new Date()));
      Log.d(paramString, stringBuilder.toString());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */