package com.laiqian.dcb.api.b.a;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class b {
  public static String decode(String paramString) {
    try {
      return new String(decode(a.decode(paramString)));
    } catch (Exception paramString) {
      return "";
    } 
  }
  
  public static byte[] decode(byte[] paramArrayOfByte) throws Exception {
    try {
      DESKeySpec dESKeySpec = new DESKeySpec("giveMe@1".getBytes());
      SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec);
      Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      cipher.init(2, secretKey, new IvParameterSpec("20111126".getBytes()));
      return cipher.doFinal(paramArrayOfByte);
    } catch (Exception paramArrayOfByte) {
      throw new Exception(paramArrayOfByte);
    } 
  }
  
  public static String e(byte[] paramArrayOfByte) throws Exception {
    try {
      DESKeySpec dESKeySpec = new DESKeySpec("giveMe@1".getBytes());
      SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec);
      Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      cipher.init(1, secretKey, new IvParameterSpec("20111126".getBytes()));
      return a.e(cipher.doFinal(paramArrayOfByte));
    } catch (Exception paramArrayOfByte) {
      throw new Exception(paramArrayOfByte);
    } 
  }
  
  public static String encode(String paramString) { return e(paramString.getBytes()); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */