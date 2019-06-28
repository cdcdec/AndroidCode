package com.laiqian.print.util;

import com.google.a.a.a.a.a.a;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LqkEncrypt {
  private static String cOw = "000000";
  
  static  {
    System.loadLibrary("lqk_encrypt");
  }
  
  public static byte[] ajc() {
    long l = System.currentTimeMillis();
    null = new StringBuilder();
    null.append("southafrica_001");
    null.append(l);
    str = null.toString();
    try {
      byte[] arrayOfByte = MessageDigest.getInstance("SHA-256").digest(str.getBytes());
    } catch (NoSuchAlgorithmException str) {
      a.e(str);
      str = null;
    } 
    return Arrays.copyOf(str, 20);
  }
  
  public static String ajd() { return (cOw.length() > 6) ? cOw.substring(0, 6) : cOw; }
  
  public static byte[] aje() {
    str = ajd();
    try {
      return str.getBytes("US-ASCII");
    } catch (UnsupportedEncodingException str) {
      return new byte[] { 48, 48, 48, 48, 48, 48 };
    } 
  }
  
  private static native byte[] sign(byte[] paramArrayOfByte);
  
  public static byte[] y(byte[] paramArrayOfByte) { return sign(paramArrayOfByte); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\util\LqkEncrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */