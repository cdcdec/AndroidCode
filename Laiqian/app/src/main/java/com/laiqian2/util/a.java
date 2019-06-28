package com.laiqian.util;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {
  public static byte[] b(String paramString, byte[] paramArrayOfByte) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfByte, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      null = paramString.getBytes("UTF-8");
      cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[16]));
      return cipher.doFinal(null);
    } catch (NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException|java.security.InvalidKeyException|java.io.UnsupportedEncodingException|javax.crypto.IllegalBlockSizeException|javax.crypto.BadPaddingException|java.security.InvalidAlgorithmParameterException paramString) {
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */