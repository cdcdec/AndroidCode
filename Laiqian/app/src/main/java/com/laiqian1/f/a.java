package com.laiqian.f;

import com.laiqian.util.bb;

public final class a {
  private static final byte[] aQj;
  
  private static final char[] aQk;
  
  static  {
    byte b5;
    byte b4;
    byte b3;
    byte b2;
    aQj = new byte[128];
    aQk = new char[64];
    boolean bool = false;
    byte b1;
    for (b1 = 0; b1 < ''; b1++)
      aQj[b1] = -1; 
    for (b1 = 90; b1 >= 65; b1--)
      aQj[b1] = (byte)(b1 - 65); 
    b1 = 122;
    while (true) {
      b2 = 26;
      if (b1 >= 97) {
        aQj[b1] = (byte)(b1 - 97 + 26);
        b1--;
        continue;
      } 
      break;
    } 
    b1 = 57;
    while (true) {
      b5 = 52;
      if (b1 >= 48) {
        aQj[b1] = (byte)(b1 - 48 + 52);
        b1--;
        continue;
      } 
      break;
    } 
    aQj[43] = 62;
    aQj[47] = 63;
    for (b1 = 0; b1 <= 25; b1++)
      aQk[b1] = (char)(b1 + 65); 
    b1 = 0;
    while (true) {
      b3 = bool;
      b4 = b5;
      if (b2 <= 51) {
        aQk[b2] = (char)(b1 + 97);
        b2++;
        b1++;
        continue;
      } 
      break;
    } 
    while (b4 <= 61) {
      aQk[b4] = (char)(b3 + 48);
      b4++;
      b3++;
    } 
    aQk[62] = '+';
    aQk[63] = '/';
  }
  
  public static byte[] decode(String paramString) {
    if (paramString == null)
      return null; 
    char[] arrayOfChar = paramString.toCharArray();
    int i = i(arrayOfChar);
    if (i % 4 != 0)
      return null; 
    int j = i / 4;
    if (j == 0)
      return new byte[0]; 
    byte[] arrayOfByte = new byte[j * 3];
    byte b1 = 0;
    byte b2 = 0;
    i = 0;
    while (b1 < j - 1) {
      byte b = b2 + true;
      char c1 = arrayOfChar[b2];
      if (k(c1)) {
        byte b3 = b + true;
        char c2 = arrayOfChar[b];
        if (k(c2)) {
          b2 = b3 + true;
          char c3 = arrayOfChar[b3];
          if (k(c3)) {
            char c4 = arrayOfChar[b2];
            if (!k(c4))
              return null; 
            byte b5 = aQj[c1];
            byte b4 = aQj[c2];
            b = aQj[c3];
            b3 = aQj[c4];
            int k = i + 1;
            arrayOfByte[i] = (byte)(b5 << 2 | b4 >> 4);
            int m = k + 1;
            arrayOfByte[k] = (byte)((b4 & 0xF) << 4 | b >> 2 & 0xF);
            i = m + 1;
            arrayOfByte[m] = (byte)(b << 6 | b3);
            b1++;
            b2++;
            continue;
          } 
        } 
      } 
      return null;
    } 
    j = b2 + 1;
    char c = arrayOfChar[b2];
    if (k(c)) {
      int k = j + 1;
      char c1 = arrayOfChar[j];
      if (!k(c1))
        return null; 
      b2 = aQj[c];
      j = aQj[c1];
      c = arrayOfChar[k];
      c1 = arrayOfChar[k + 1];
      if (!k(c) || !k(c1)) {
        if (j(c) && j(c1)) {
          if ((j & 0xF) != 0)
            return null; 
          b1 *= 3;
          byte[] arrayOfByte1 = new byte[b1 + 1];
          System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, b1);
          arrayOfByte1[i] = (byte)(b2 << 2 | j >> 4);
          return arrayOfByte1;
        } 
        if (!j(c) && j(c1)) {
          k = aQj[c];
          if ((k & 0x3) != 0)
            return null; 
          b1 *= 3;
          byte[] arrayOfByte1 = new byte[b1 + 2];
          System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, b1);
          arrayOfByte1[i] = (byte)(b2 << 2 | j >> 4);
          arrayOfByte1[i + 1] = (byte)(k >> 2 & 0xF | (j & 0xF) << 4);
          return arrayOfByte1;
        } 
        return null;
      } 
      b1 = aQj[c];
      k = aQj[c1];
      int m = i + 1;
      arrayOfByte[i] = (byte)(b2 << 2 | j >> 4);
      arrayOfByte[m] = (byte)((j & 0xF) << 4 | b1 >> 2 & 0xF);
      arrayOfByte[m + 1] = (byte)(k | b1 << 6);
      bb.ao(arrayOfByte);
      return arrayOfByte;
    } 
    return null;
  }
  
  public static String e(byte[] paramArrayOfByte) {
    if (paramArrayOfByte == null)
      return null; 
    int i = paramArrayOfByte.length * 8;
    if (i == 0)
      return ""; 
    int m = i % 24;
    int k = i / 24;
    if (m != 0) {
      i = k + 1;
    } else {
      i = k;
    } 
    char[] arrayOfChar = new char[i * 4];
    int j = 0;
    short s = 0;
    i = 0;
    while (j < k) {
      byte b = s + true;
      s = paramArrayOfByte[s];
      boolean bool = b + true;
      byte b4 = paramArrayOfByte[b];
      b = paramArrayOfByte[bool];
      byte b1 = (byte)(b4 & 0xF);
      byte b2 = (byte)(s & 0x3);
      if ((s & 0xFFFFFF80) == 0) {
        s >>= 2;
      } else {
        s = s >> 2 ^ 0xC0;
      } 
      byte b3 = (byte)s;
      if ((b4 & 0xFFFFFF80) == 0) {
        s = b4 >> 4;
      } else {
        s = b4 >> 4 ^ 0xF0;
      } 
      b4 = (byte)s;
      if ((b & 0xFFFFFF80) == 0) {
        s = b >> 6;
      } else {
        s = b >> 6 ^ 0xFC;
      } 
      s = (byte)s;
      int i1 = i + 1;
      arrayOfChar[i] = aQk[b3];
      i = i1 + 1;
      arrayOfChar[i1] = aQk[b4 | b2 << 4];
      int n = i + 1;
      arrayOfChar[i] = aQk[b1 << 2 | s];
      arrayOfChar[n] = aQk[b & 0x3F];
      j++;
      i = n + 1;
      s = bool + true;
    } 
    if (m == 8) {
      j = paramArrayOfByte[s];
      s = (byte)(j & 0x3);
      if ((j & 0xFFFFFF80) == 0) {
        j >>= 2;
      } else {
        j = j >> 2 ^ 0xC0;
      } 
      k = (byte)j;
      j = i + 1;
      arrayOfChar[i] = aQk[k];
      i = j + 1;
      arrayOfChar[j] = aQk[s << 4];
      arrayOfChar[i] = '=';
      arrayOfChar[i + 1] = '=';
    } else if (m == 16) {
      j = paramArrayOfByte[s];
      byte b = paramArrayOfByte[s + 1];
      s = (byte)(b & 0xF);
      k = (byte)(j & 0x3);
      if ((j & 0xFFFFFF80) == 0) {
        j >>= 2;
      } else {
        j = j >> 2 ^ 0xC0;
      } 
      m = (byte)j;
      if ((b & 0xFFFFFF80) == 0) {
        j = b >> 4;
      } else {
        j = b >> 4 ^ 0xF0;
      } 
      j = (byte)j;
      int n = i + 1;
      arrayOfChar[i] = aQk[m];
      i = n + 1;
      arrayOfChar[n] = aQk[j | k << 4];
      arrayOfChar[i] = aQk[s << 2];
      arrayOfChar[i + 1] = '=';
    } 
    return new String(arrayOfChar);
  }
  
  private static int i(char[] paramArrayOfChar) {
    byte b1 = 0;
    if (paramArrayOfChar == null)
      return 0; 
    int i = paramArrayOfChar.length;
    byte b2;
    for (b2 = 0; b1 < i; b2 = b) {
      byte b = b2;
      if (!i(paramArrayOfChar[b1])) {
        paramArrayOfChar[b2] = paramArrayOfChar[b1];
        b = b2 + true;
      } 
      b1++;
    } 
    return b2;
  }
  
  private static boolean i(char paramChar) { return (paramChar == ' ' || paramChar == '\r' || paramChar == '\n' || paramChar == '\t'); }
  
  private static boolean j(char paramChar) { return (paramChar == '='); }
  
  private static boolean k(char paramChar) { return (paramChar < '' && aQj[paramChar] != -1); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */