package com.laiqian.f;

import android.util.Base64;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.bb;
import com.laiqian.util.n;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class b {
  public static String c(long paramLong, int paramInt) {
    String str1 = String.valueOf(paramLong);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("sTimeStamp:");
    stringBuilder2.append(str1);
    Log.d("EncryptDecryptMethod", stringBuilder2.toString());
    paramInt = n.parseInt(Integer.toOctalString(paramInt));
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("octalShopId:");
    stringBuilder2.append(paramInt);
    Log.d("EncryptDecryptMethod", stringBuilder2.toString());
    paramLong = paramInt + 83979897111L;
    if (String.valueOf(paramLong).length() < 9 || str1.length() < 9)
      return ""; 
    paramInt = n.parseInt(n.bD(1, 9));
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("index:");
    stringBuilder2.append(paramInt);
    Log.d("EncryptDecryptMethod", stringBuilder2.toString());
    int i = n.parseInt(n.bD(3, 9));
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("length:");
    stringBuilder2.append(i);
    Log.d("EncryptDecryptMethod", stringBuilder2.toString());
    String str2 = String.valueOf((paramLong * 10L + i) * 10L + paramInt);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("sParam:");
    stringBuilder3.append(str2);
    Log.d("EncryptDecryptMethod", stringBuilder3.toString());
    str1 = str1.substring(str1.length() - i, str1.length());
    str1 = (new StringBuilder(str2)).insert(paramInt, str1).toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("sParam: ");
    stringBuilder1.append(str1);
    Log.d("EncryptDecryptMethod", stringBuilder1.toString());
    return str1;
  }
  
  public static String cL(String paramString) throws Exception { return t(paramString.getBytes()); }
  
  public static String cM(String paramString) throws Exception {
    try {
      bb.ao(a.decode(paramString));
      return new String(u(a.decode(paramString)));
    } catch (Exception paramString) {
      return "";
    } 
  }
  
  public static String decode(String paramString) throws Exception {
    try {
      byte[] arrayOfByte1 = Base64.decode(paramString, 0);
      byte[] arrayOfByte2 = decode(arrayOfByte1);
      bb.ao(arrayOfByte1);
      return new String(arrayOfByte2);
    } catch (Exception exception) {
      a.e(exception);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("data is ");
      stringBuilder.append(paramString);
      Log.e("EncryptDecryptMethod", stringBuilder.toString());
      return "";
    } 
  }
  
  public static byte[] decode(byte[] paramArrayOfByte) throws Exception {
    try {
      DESKeySpec dESKeySpec = new DESKeySpec("giveMe@1billion".getBytes());
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
      DESKeySpec dESKeySpec = new DESKeySpec("giveMe@1billion".getBytes());
      SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec);
      Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      cipher.init(1, secretKey, new IvParameterSpec("20111126".getBytes()));
      return a.e(cipher.doFinal(paramArrayOfByte));
    } catch (Exception paramArrayOfByte) {
      throw new Exception(paramArrayOfByte);
    } 
  }
  
  public static String encode(String paramString) throws Exception { return e(paramString.getBytes()); }
  
  public static String t(byte[] paramArrayOfByte) throws Exception {
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
  
  public static byte[] u(byte[] paramArrayOfByte) throws Exception {
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
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */