package com.laiqian.opentable.common;

import android.util.Log;

public class u {
  private static String TAG = "u";
  
  static  {
  
  }
  
  public static void XO() { Log.e(TAG, "start Refresh Area After Receiving Message."); }
  
  public static void XP() { Log.e(TAG, "start Refresh Table List."); }
  
  public static void XQ() { Log.e(TAG, "finish Refresh Table List."); }
  
  public static void jh(String paramString) { Log.e(TAG, "start Process New Message."); }
  
  public static void ji(String paramString) {
    Log.e(TAG, "finishProcessNewMessage, and send message broadcast.");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("处理获取的消息,");
    stringBuilder.append(paramString);
    b.je(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\commo\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */