package com.laiqian.f;

import com.google.a.a.a.a.a.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c {
  public static String aQl = "";
  
  static  {
  
  }
  
  public static String D(String paramString1, String paramString2) {
    paramString2 = paramString2.substring(paramString2.length() - 1, paramString2.length());
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(paramString1);
      stringBuilder.append(paramString2);
      return cI(stringBuilder.toString());
    } catch (NoSuchAlgorithmException paramString1) {
      a.e(paramString1);
      return null;
    } 
  }
  
  public static String E(String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(paramString1);
      stringBuilder.append(paramString2);
      return cI(stringBuilder.toString());
    } catch (NoSuchAlgorithmException paramString1) {
      a.e(paramString1);
      return null;
    } 
  }
  
  public static String F(String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(paramString1);
      stringBuilder.append(paramString2);
      return cI(stringBuilder.toString());
    } catch (NoSuchAlgorithmException paramString1) {
      a.e(paramString1);
      return null;
    } 
  }
  
  public static String cI(String paramString) throws NoSuchAlgorithmException {
    StringBuilder stringBuilder = new StringBuilder();
    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    messageDigest.update(paramString.getBytes());
    byte[] arrayOfByte = messageDigest.digest();
    for (byte b = 0; b < arrayOfByte.length; b++) {
      if ((arrayOfByte[b] & 0xFF) < 16)
        stringBuilder.append("0"); 
      stringBuilder.append(Long.toString((arrayOfByte[b] & 0xFF), 16));
    } 
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */