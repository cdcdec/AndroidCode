package com.laiqian.print.model.b;

import android.graphics.Bitmap;
import com.laiqian.print.util.b;
import com.laiqian.print.util.e;

public class a {
  private static int[] cHA;
  
  private static int[][] cHt;
  
  private static int[] cHu;
  
  private static int[] cHv;
  
  private static int[] cHw;
  
  private static int[] cHx;
  
  private static int[] cHy;
  
  private static int[] cHz;
  
  static  {
    int[] arrayOfInt1 = { 
        0, 128, 32, 160, 8, 136, 40, 168, 2, 130, 
        34, 162, 10, 138, 42, 170 };
    int[] arrayOfInt2 = { 
        192, 64, 224, 96, 200, 72, 232, 104, 194, 66, 
        226, 98, 202, 74, 234, 106 };
    int[] arrayOfInt3 = { 
        48, 176, 16, 144, 56, 184, 24, 152, 50, 178, 
        18, 146, 58, 186, 26, 154 };
    int[] arrayOfInt4 = { 
        240, 112, 208, 80, 248, 120, 216, 88, 242, 114, 
        210, 82, 250, 122, 218, 90 };
    int[] arrayOfInt5 = { 
        12, 140, 44, 172, 4, 132, 36, 164, 14, 142, 
        46, 174, 6, 134, 38, 166 };
    int[] arrayOfInt6 = { 
        204, 76, 236, 108, 196, 68, 228, 100, 206, 78, 
        238, 110, 198, 70, 230, 102 };
    int[] arrayOfInt7 = { 
        60, 188, 28, 156, 52, 180, 20, 148, 62, 190, 
        30, 158, 54, 182, 22, 150 };
    int[] arrayOfInt8 = { 
        252, 124, 220, 92, 244, 116, 212, 84, 254, 126, 
        222, 94, 246, 118, 214, 86 };
    int[] arrayOfInt9 = { 
        3, 131, 35, 163, 11, 139, 43, 171, 1, 129, 
        33, 161, 9, 137, 41, 169 };
    int[] arrayOfInt10 = { 
        51, 179, 19, 147, 59, 187, 27, 155, 49, 177, 
        17, 145, 57, 185, 25, 153 };
    int[] arrayOfInt11 = { 
        243, 115, 211, 83, 251, 123, 219, 91, 241, 113, 
        209, 81, 249, 121, 217, 89 };
    int[] arrayOfInt12 = { 
        15, 143, 47, 175, 7, 135, 39, 167, 13, 141, 
        45, 173, 5, 133, 37, 165 };
    int[] arrayOfInt13 = { 
        207, 79, 239, 111, 199, 71, 231, 103, 205, 77, 
        237, 109, 197, 69, 229, 101 };
    int[] arrayOfInt14 = { 
        63, 191, 31, 159, 55, 183, 23, 151, 61, 189, 
        29, 157, 53, 181, 21, 149 };
    int[] arrayOfInt15 = { 
        254, 127, 223, 95, 247, 119, 215, 87, 253, 125, 
        221, 93, 245, 117, 213, 85 };
    cHt = new int[][] { 
        arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, { 
          195, 67, 227, 99, 203, 75, 235, 107, 193, 65, 
          225, 97, 201, 73, 233, 105 }, 
        arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, arrayOfInt14, arrayOfInt15 };
    cHu = new int[] { 0, 128 };
    cHv = new int[] { 0, 64 };
    cHw = new int[] { 0, 32 };
    cHx = new int[] { 0, 16 };
    cHy = new int[] { 0, 8 };
    cHz = new int[] { 0, 4 };
    cHA = new int[] { 0, 2 };
  }
  
  private static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, byte[] paramArrayOfByte) {
    byte b2 = 0;
    byte b1 = 0;
    while (b2 < paramInt2) {
      byte b;
      for (b = 0; b < paramInt1; b++) {
        if ((paramArrayOfInt[b1] & 0xFF) > cHt[b & 0xF][b2 & 0xF]) {
          paramArrayOfByte[b1] = 0;
        } else {
          paramArrayOfByte[b1] = 1;
        } 
        b1++;
      } 
      b2++;
    } 
  }
  
  public static byte[] a(byte paramByte1, byte paramByte2, byte paramByte3) { return new byte[] { 27, 112, paramByte1, paramByte2, paramByte3 }; }
  
  public static byte[] a(Bitmap paramBitmap, int paramInt1, int paramInt2) {
    if (paramInt1 == 0)
      paramInt1 = 58; 
    paramInt1 = e.jh(paramInt1);
    if (paramBitmap.getWidth() > paramInt1) {
      double d = paramInt1 / paramBitmap.getWidth();
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, (int)(paramBitmap.getHeight() * d), true);
    } 
    paramBitmap = e.s(paramBitmap);
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    paramInt1 -= j;
    switch (paramInt2) {
      case 1:
        paramInt1 /= 2;
        break;
      case 0:
        paramInt1 = 0;
        break;
    } 
    paramInt2 = j + paramInt1;
    byte b1 = ik(paramInt2)[0];
    byte b2 = ik(paramInt2)[1];
    b b = new b(false);
    b.s(c((byte)0));
    paramInt2 = 0;
    while (paramInt2 < i) {
      b.s(new byte[] { 27, 42, 33, b1, b2 });
      int k;
      for (k = 0; k < paramInt1; k++) {
        byte b3;
        for (b3 = 0; b3 < 3; b3++)
          b.append(0); 
      } 
      for (k = 0; k < j; k++) {
        int m;
        for (m = 0; m < 3; m++) {
          byte b3 = 0;
          int n;
          for (n = 0; n < 8; n++) {
            boolean bool;
            int i1 = (paramInt2 / 8 + m) * 8 + n;
            if (i1 * j + k < j * i) {
              bool = j(paramBitmap.getPixel(k, i1), k, i1);
            } else {
              bool = false;
            } 
            if (bool) {
              i1 = 1;
            } else {
              i1 = 0;
            } 
            b3 = (byte)(b3 | (byte)(i1 << 7 - n));
          } 
          b.append(b3);
        } 
      } 
      paramInt2 += 24;
      b.append(10);
    } 
    b.s(agJ());
    return b.toByteArray();
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {
    b b = new b(paramArrayOfByte1.length + 2 + paramArrayOfByte2.length);
    b.s(new byte[] { 18, 64 });
    b.s(paramArrayOfByte1);
    b.s(paramArrayOfByte2);
    b.s(paramArrayOfByte3);
    return b.toByteArray();
  }
  
  public static byte[] agI() { return new byte[] { 10 }; }
  
  public static byte[] agJ() { return new byte[] { 27, 50 }; }
  
  public static byte[] agK() { return new byte[] { 27, 64 }; }
  
  public static byte[] agL() { return new byte[] { 28, 38 }; }
  
  public static byte[] agM() { return new byte[] { 28, 46 }; }
  
  public static byte[] agN() { return new byte[] { 18, 65 }; }
  
  public static byte[] b(Bitmap paramBitmap, int paramInt) {
    int j = paramBitmap.getHeight();
    int i = paramBitmap.getWidth();
    paramInt = e.jh(paramInt);
    if (i <= paramInt)
      paramInt = i; 
    paramInt = (paramInt + 7) / 8 * 8;
    double d = paramInt / i;
    paramBitmap = e.b(paramBitmap, paramInt, (int)(j * d));
    paramInt = paramBitmap.getHeight();
    i = paramBitmap.getWidth() / 8;
    byte b1 = ik(i)[0];
    byte b2 = ik(i)[1];
    byte b3 = ik(paramInt)[0];
    byte b4 = ik(paramInt)[1];
    b b = new b(false);
    b.s(new byte[] { 29, 118, 48, 0, b1, b2, b3, b4 });
    b.s(x(r(paramBitmap)));
    return b.toByteArray();
  }
  
  public static byte[] bl(int paramInt1, int paramInt2) { return new byte[] { 27, 66, (byte)paramInt1, (byte)paramInt2 }; }
  
  public static byte[] c(byte paramByte) { return new byte[] { 27, 51, paramByte }; }
  
  public static byte[] d(byte paramByte) { return new byte[] { 27, 69, paramByte }; }
  
  public static byte[] e(byte paramByte) { return new byte[] { 27, 97, paramByte }; }
  
  public static byte[] f(byte paramByte) { return new byte[] { 27, 116, paramByte }; }
  
  public static byte[] g(byte paramByte) { return new byte[] { 29, 33, paramByte }; }
  
  public static byte[] h(byte paramByte) { return new byte[] { 29, 86, paramByte }; }
  
  private static byte[] ik(int paramInt) { return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF000000 & paramInt) >> 24) }; }
  
  private static boolean j(int paramInt1, int paramInt2, int paramInt3) { return ((paramInt1 & 0xFF) <= cHt[paramInt2 & 0xF][paramInt3 & 0xF]); }
  
  public static byte[] lr(String paramString) {
    arrayOfString = paramString.split("\\.");
    if (arrayOfString.length != 4)
      throw new IllegalArgumentException("wrong format ip address"); 
    try {
      int i = Integer.parseInt(arrayOfString[0]);
      int j = Integer.parseInt(arrayOfString[1]);
      int k = Integer.parseInt(arrayOfString[2]);
      int m = Integer.parseInt(arrayOfString[3]);
      byte b1 = (byte)i;
      byte b2 = (byte)j;
      byte b3 = (byte)k;
      byte b4 = (byte)m;
      return new byte[] { 
          31, 27, 31, -111, 0, 73, 80, b1, b2, b3, 
          b4 };
    } catch (NumberFormatException arrayOfString) {
      throw new IllegalArgumentException("wrong format ip address", arrayOfString);
    } 
  }
  
  public static byte[] ls(String paramString) {
    arrayOfString = paramString.split("\\.");
    if (arrayOfString.length != 4)
      throw new IllegalArgumentException("wrong format ip address"); 
    try {
      int i = Integer.parseInt(arrayOfString[0]);
      int j = Integer.parseInt(arrayOfString[1]);
      int k = Integer.parseInt(arrayOfString[2]);
      int m = Integer.parseInt(arrayOfString[3]);
      byte b1 = (byte)i;
      byte b2 = (byte)j;
      byte b3 = (byte)k;
      byte b4 = (byte)m;
      byte b5 = (byte)(i ^ j ^ k ^ m ^ 0x76);
      return new byte[] { 
          31, 40, 15, 7, 0, 31, 105, b1, b2, b3, 
          b4, b5 };
    } catch (NumberFormatException arrayOfString) {
      throw new IllegalArgumentException("wrong format ip address", arrayOfString);
    } 
  }
  
  private static byte[] r(Bitmap paramBitmap) {
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    byte[] arrayOfByte = new byte[paramBitmap.getWidth() * paramBitmap.getHeight()];
    Bitmap bitmap = e.s(paramBitmap);
    bitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    a(arrayOfInt, bitmap.getWidth(), bitmap.getHeight(), arrayOfByte);
    return arrayOfByte;
  }
  
  private static byte[] x(byte[] paramArrayOfByte) {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length / 8];
    byte b1 = 0;
    byte b2 = 0;
    while (b1 < arrayOfByte.length) {
      arrayOfByte[b1] = (byte)(cHu[paramArrayOfByte[b2]] + cHv[paramArrayOfByte[b2 + true]] + cHw[paramArrayOfByte[b2 + 2]] + cHx[paramArrayOfByte[b2 + 3]] + cHy[paramArrayOfByte[b2 + 4]] + cHz[paramArrayOfByte[b2 + 5]] + cHA[paramArrayOfByte[b2 + 6]] + paramArrayOfByte[b2 + 7]);
      b2 += 8;
      b1++;
    } 
    return arrayOfByte;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */