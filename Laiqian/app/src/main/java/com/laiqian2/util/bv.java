package com.laiqian.util;

public class bv {
  private static ThreadLocal<StringBuilder> dGt = new bw();
  
  public static StringBuilder awv() {
    StringBuilder stringBuilder = (StringBuilder)dGt.get();
    stringBuilder.setLength(0);
    return stringBuilder;
  }
  
  public static StringBuilder sa(String paramString) {
    StringBuilder stringBuilder = awv();
    if (paramString != null)
      stringBuilder.append(paramString); 
    return stringBuilder;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */