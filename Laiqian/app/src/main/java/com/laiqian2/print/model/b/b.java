package com.laiqian.print.model.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import com.laiqian.print.util.b;

@SuppressLint({"DefaultLocale"})
public class b {
  public static String a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2) { return String.format("BARCODE %d,%d,\"%s\",%d,%d,%d,%d,%d,\"%s\"\r\n", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2 }); }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, String paramString2) { return String.format("TEXT %d,%d,\"%s\",%d,%d,%d,\"%s\"\r\n", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString2 }); }
  
  private static byte[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte) {
    String str = String.format("BITMAP %d,%d,%d,%d,%d,", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
    b b1 = new b(false);
    b1.s(str.getBytes());
    b1.s(paramArrayOfByte);
    return b1.toByteArray();
  }
  
  public static byte[] a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap) {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    b b2 = new b(false);
    int k = (i + 7) / 8;
    byte b1;
    for (b1 = 0; b1 < j; b1++) {
      byte b3;
      for (b3 = 0; b3 < k; b3++) {
        byte b4 = 0;
        byte b5 = 0;
        while (b4 < 8) {
          byte b6 = b3 * 8 + b4;
          byte b7 = 1;
          if (b6 < i && b1 < j) {
            boolean bool = il(paramBitmap.getPixel(b6, b1)) ^ true;
          } else {
            b6 = 1;
          } 
          if (b6 != 0) {
            b6 = b7;
          } else {
            b6 = 0;
          } 
          b5 = (byte)(b5 | (byte)(b6 << 7 - b4));
          b4++;
        } 
        b2.append(b5);
      } 
    } 
    return a(paramInt1, paramInt2, k, j, paramInt3, b2.toByteArray());
  }
  
  public static String agO() { return "CLS\r\n"; }
  
  public static String agP() { return "INITIALPRINTER\r\n"; }
  
  public static byte[] b(byte paramByte1, byte paramByte2, byte paramByte3) { return new byte[] { 27, 112, paramByte1, paramByte2, paramByte3 }; }
  
  public static String bm(int paramInt1, int paramInt2) { return String.format("SIZE %d mm, %d mm\r\n", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }); }
  
  public static String bn(int paramInt1, int paramInt2) { return String.format("GAP %d mm, %d mm\r\n", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }); }
  
  public static String bo(int paramInt1, int paramInt2) { return String.format("DIRECTION %d,%d\r\n", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }); }
  
  public static String bp(int paramInt1, int paramInt2) { return String.format("PRINT %d, %d\r\n", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }); }
  
  private static boolean il(int paramInt) { return ((int)(Color.red(paramInt) * 0.3D + Color.green(paramInt) * 0.59D + Color.blue(paramInt) * 0.11D) * Color.alpha(paramInt) / 255 < 127); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */