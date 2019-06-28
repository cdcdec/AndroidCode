package com.laiqian.meituan.c;

import com.google.a.a.a.a.a.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class e {
  public static String fq(String paramString) {
    try {
      return w(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
    } catch (NoSuchAlgorithmException paramString) {
      a.e(paramString);
      return null;
    } 
  }
  
  private static String w(byte[] paramArrayOfByte) {
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0; b < paramArrayOfByte.length; b++) {
      byte b2 = paramArrayOfByte[b];
      byte b1 = b2;
      if (b2 < 0)
        b1 = b2 + 256; 
      if (b1 < 16)
        stringBuffer.append("0"); 
      stringBuffer.append(Integer.toHexString(b1));
    } 
    return stringBuffer.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */