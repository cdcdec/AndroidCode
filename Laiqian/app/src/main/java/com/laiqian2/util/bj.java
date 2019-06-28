package com.laiqian.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class bj {
  private static bj dGk;
  
  private byte[] e = null;
  
  private String f;
  
  private String a(String paramString) {
    try {
      null = MessageDigest.getInstance("MD5");
      null.update(paramString.getBytes());
      byte[] arrayOfByte = null.digest();
      StringBuffer stringBuffer = new StringBuffer("");
      for (byte b = 0; b < arrayOfByte.length; b++) {
        byte b2 = arrayOfByte[b];
        byte b1 = b2;
        if (b2 < 0)
          b1 = b2 + 256; 
        if (b1 < 16)
          stringBuffer.append("0"); 
        stringBuffer.append(Integer.toHexString(b1));
      } 
      return stringBuffer.toString();
    } catch (NoSuchAlgorithmException paramString) {
      return null;
    } 
  }
  
  public static bj awq() {
    if (dGk == null)
      dGk = new bj(); 
    return dGk;
  }
  
  public void initialize(Context paramContext) {
    try {
      null = paramContext.getApplicationContext().getPackageName();
      bj bj1 = dGk;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null);
      stringBuilder.append(System.currentTimeMillis());
      this.f = bj1.a(stringBuilder.toString());
      if (this.f == null)
        this.f = String.valueOf(System.currentTimeMillis()); 
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (applicationInfo != null && applicationInfo.metaData != null) {
        String str2 = applicationInfo.metaData.getString("PUSH_APPID");
        null = applicationInfo.metaData.getString("PUSH_APPSECRET");
        if (applicationInfo.metaData.get("PUSH_APPKEY") != null) {
          String str = applicationInfo.metaData.get("PUSH_APPKEY").toString();
        } else {
          applicationInfo = null;
        } 
        String str1 = str2;
        if (str2 != null)
          str1 = str2.trim(); 
        str2 = null;
        if (null != null)
          str2 = null.trim(); 
        String str3 = applicationInfo;
        if (applicationInfo != null)
          str3 = applicationInfo.trim(); 
        if (!str1.equals("") && !str2.equals("") && !str3.equals("")) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str1);
          stringBuilder1.append(str2);
          stringBuilder1.append(str3);
          stringBuilder1.append(paramContext.getPackageName());
          this.e = a(stringBuilder1.toString()).getBytes();
        } 
      } 
      return;
    } catch (Exception paramContext) {
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */