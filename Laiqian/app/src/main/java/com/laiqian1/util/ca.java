package com.laiqian.util;

import com.google.a.a.a.a.a.a;
import java.lang.reflect.Method;

public class ca {
  private static Method dGA;
  
  private static Class<?> dGy;
  
  private static Method dGz;
  
  static  {
  
  }
  
  public static String get(String paramString1, String paramString2) {
    init();
    try {
      return (String)dGz.invoke(dGy, new Object[] { paramString1, paramString2 });
    } catch (Exception paramString1) {
      a.e(paramString1);
      return null;
    } 
  }
  
  public static int getInt(String paramString, int paramInt) {
    init();
    try {
      return ((Integer)dGA.invoke(dGy, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
    } catch (Exception paramString) {
      a.e(paramString);
      return paramInt;
    } 
  }
  
  private static void init() {
    try {
      if (dGy == null) {
        dGy = Class.forName("android.os.SystemProperties");
        dGz = dGy.getDeclaredMethod("get", new Class[] { String.class, String.class });
        dGA = dGy.getDeclaredMethod("getInt", new Class[] { String.class, int.class });
        return;
      } 
    } catch (Exception exception) {
      a.e(exception);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\util\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */