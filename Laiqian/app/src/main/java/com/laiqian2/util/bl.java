package com.laiqian.util;

import android.graphics.Bitmap;
import com.google.zxing.LuminanceSource;

public final class bl extends LuminanceSource {
  private final byte[] luminances;
  
  public bl(Bitmap paramBitmap) {
    super(paramBitmap.getWidth(), paramBitmap.getHeight());
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int i = j * k;
    int[] arrayOfInt = new int[i];
    paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
    this.luminances = new byte[i];
    for (i = 0; i < k; i++) {
      for (int m = 0; m < j; m++) {
        int n = i * j + m;
        int i3 = arrayOfInt[n];
        int i1 = i3 >> 16 & 0xFF;
        int i2 = i3 >> 8 & 0xFF;
        i3 &= 0xFF;
        if (i1 == i2 && i2 == i3) {
          this.luminances[n] = (byte)i1;
        } else {
          this.luminances[n] = (byte)(i1 + i2 + i2 + i3 >> 2);
        } 
      } 
    } 
  }
  
  public byte[] getMatrix() { return this.luminances; }
  
  public byte[] getRow(int paramInt, byte[] paramArrayOfByte) {
    StringBuilder stringBuilder;
    if (paramInt < 0 || paramInt >= getHeight()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Requested row is outside the image: ");
      stringBuilder.append(paramInt);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    int i = getWidth();
    if (stringBuilder != null) {
      byte[] arrayOfByte1 = stringBuilder;
      if (stringBuilder.length < i) {
        arrayOfByte1 = new byte[i];
        System.arraycopy(this.luminances, paramInt * i, arrayOfByte1, 0, i);
        return arrayOfByte1;
      } 
      System.arraycopy(this.luminances, paramInt * i, arrayOfByte1, 0, i);
      return arrayOfByte1;
    } 
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.luminances, paramInt * i, arrayOfByte, 0, i);
    return arrayOfByte;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */