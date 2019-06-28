package com.laiqian.meituan.c;

import android.text.TextUtils;
import java.security.MessageDigest;

public class d {
  private static final String[] bso = { 
      "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
      "a", "b", "c", "d", "e", "f" };
  
  private static String b(byte paramByte) {
    byte b = paramByte;
    if (paramByte < 0)
      b = paramByte + 256; 
    paramByte = b / 16;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bso[paramByte]);
    stringBuilder.append(bso[b % 16]);
    return stringBuilder.toString();
  }
  
  public static String fp(String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
    messageDigest.update(paramString.getBytes());
    return v(messageDigest.digest());
  }
  
  private static String v(byte[] paramArrayOfByte) {
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0; b < paramArrayOfByte.length; b++)
      stringBuffer.append(b(paramArrayOfByte[b])); 
    return stringBuffer.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */