package com.laiqian.meituan.c;

public class a {
  private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  private static int[] bsn = new int[128];
  
  static  {
    for (byte b = 0; b < ALPHABET.length; b++)
      bsn[ALPHABET[b]] = b; 
  }
  
  public static String e(byte[] paramArrayOfByte) {
    int i = paramArrayOfByte.length;
    char[] arrayOfChar = new char[(i + 2) / 3 * 4];
    byte b2 = 0;
    byte b1 = 0;
    while (b2 < i) {
      boolean bool1;
      byte b = b2 + true;
      byte b3 = paramArrayOfByte[b2];
      if (b < i) {
        b2 = b + true;
        b = paramArrayOfByte[b];
      } else {
        b2 = b;
        b = 0;
      } 
      if (b2 < i) {
        byte b4 = b2 + 1;
        bool1 = paramArrayOfByte[b2];
        b2 = b4;
      } else {
        bool1 = false;
      } 
      boolean bool2 = b1 + true;
      arrayOfChar[b1] = ALPHABET[b3 >> 2 & 0x3F];
      b1 = bool2 + true;
      arrayOfChar[bool2] = ALPHABET[(b3 << 4 | (b & 0xFF) >> 4) & 0x3F];
      bool2 = b1 + true;
      arrayOfChar[b1] = ALPHABET[(b << 2 | (bool1 & 0xFF) >> '\006') & 0x3F];
      b1 = bool2 + true;
      arrayOfChar[bool2] = ALPHABET[bool1 & 0x3F];
    } 
    b2 = b1;
    switch (i % 3) {
      case 1:
        b2 = b1 - 1;
        arrayOfChar[b2] = '=';
      case 2:
        arrayOfChar[b2 - 1] = '=';
        break;
    } 
    return new String(arrayOfChar);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */