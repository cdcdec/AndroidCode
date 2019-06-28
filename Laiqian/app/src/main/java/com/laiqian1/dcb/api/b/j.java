package com.laiqian.dcb.api.b;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.google.a.a.a.a.a.a;
import com.laiqian.dcb.api.b.a.b;
import java.util.ArrayList;

public class j {
  static String key = "Z10m1hy4jN25u3U9";
  
  static  {
  
  }
  
  public static int Y(long paramLong) {
    char c;
    str = "4";
    try {
      String str1 = String.valueOf(paramLong);
      int i = str1.length();
      c = i - 1;
      while (true) {
        if (c >= i - 4) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          if (c >= 0) {
            Character character = Character.valueOf(str1.charAt(c));
          } else {
            str = "0";
          } 
          stringBuilder.append(str);
          str = stringBuilder.toString();
          c--;
          continue;
        } 
        c = Integer.parseInt(str);
        d.e("getServerPortByShopID", String.valueOf(c));
        return c;
      } 
    } catch (Exception str) {
      System.out.println(str);
      c = '㪾';
    } 
    d.e("getServerPortByShopID", String.valueOf(c));
    return c;
  }
  
  public static int Z(long paramLong) { return Y(paramLong) + 1; }
  
  public static void a(Context paramContext, BroadcastReceiver paramBroadcastReceiver, int paramInt) {
    IntentFilter intentFilter = new IntentFilter();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("method");
    stringBuilder.append(paramInt);
    if (!intentFilter.hasAction(stringBuilder.toString())) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("method");
      stringBuilder.append(paramInt);
      intentFilter.addAction(stringBuilder.toString());
      paramContext.registerReceiver(paramBroadcastReceiver, intentFilter);
    } 
  }
  
  public static String cG(String paramString) {
    try {
      return b.encode(paramString);
    } catch (Exception exception) {
      a.e(exception);
      return paramString;
    } 
  }
  
  public static String cH(String paramString) { return b.decode(paramString); }
  
  public static boolean k(Context paramContext, String paramString) {
    ArrayList arrayList = (ArrayList)((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(30);
    for (byte b = 0; b < arrayList.size(); b++) {
      if (((ActivityManager.RunningServiceInfo)arrayList.get(b)).service.getClassName().toString().equals(paramString))
        return true; 
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */