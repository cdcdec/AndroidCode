package com.laiqian.dcb.api.b.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c {
  public static String aQl = "";
  
  static  {
  
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */