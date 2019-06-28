package com.laiqian.util;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;

public final class al {
  public static Bitmap B(String paramString, int paramInt) throws WriterException {
    (new Hashtable()).put(EncodeHintType.CHARACTER_SET, "utf-8");
    BitMatrix bitMatrix = (new MultiFormatWriter()).encode(paramString, BarcodeFormat.QR_CODE, paramInt, paramInt);
    int i = bitMatrix.getWidth();
    int j = bitMatrix.getHeight();
    int[] arrayOfInt = new int[i * j];
    for (paramInt = 0; paramInt < j; paramInt++) {
      for (int k = 0; k < i; k++) {
        if (bitMatrix.get(k, paramInt)) {
          arrayOfInt[paramInt * i + k] = -16777216;
        } else {
          arrayOfInt[paramInt * i + k] = -1;
        } 
      } 
    } 
    Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    bitmap.setPixels(arrayOfInt, 0, i, 0, 0, i, j);
    return bitmap;
  }
  
  public static Bitmap C(String paramString, int paramInt) throws WriterException {
    null = new Hashtable();
    null.put(EncodeHintType.CHARACTER_SET, "utf-8");
    null.put(EncodeHintType.MARGIN, Integer.valueOf(0));
    BitMatrix bitMatrix = (new MultiFormatWriter()).encode(paramString, BarcodeFormat.QR_CODE, paramInt, paramInt, null);
    int i = bitMatrix.getWidth();
    int j = bitMatrix.getHeight();
    int[] arrayOfInt = new int[i * j];
    for (paramInt = 0; paramInt < j; paramInt++) {
      for (int k = 0; k < i; k++) {
        if (bitMatrix.get(k, paramInt)) {
          arrayOfInt[paramInt * i + k] = -1814204;
        } else {
          arrayOfInt[paramInt * i + k] = -1;
        } 
      } 
    } 
    Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    bitmap.setPixels(arrayOfInt, 0, i, 0, 0, i, j);
    return bitmap;
  }
  
  public static Bitmap D(String paramString, int paramInt) throws WriterException {
    null = new Hashtable();
    null.put(EncodeHintType.CHARACTER_SET, "utf-8");
    null.put(EncodeHintType.MARGIN, Integer.valueOf(0));
    BitMatrix bitMatrix = (new MultiFormatWriter()).encode(paramString, BarcodeFormat.QR_CODE, paramInt, paramInt, null);
    int i = bitMatrix.getWidth();
    int j = bitMatrix.getHeight();
    int[] arrayOfInt = new int[i * j];
    for (paramInt = 0; paramInt < j; paramInt++) {
      for (int k = 0; k < i; k++) {
        if (bitMatrix.get(k, paramInt)) {
          arrayOfInt[paramInt * i + k] = -15165976;
        } else {
          arrayOfInt[paramInt * i + k] = -1;
        } 
      } 
    } 
    Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    bitmap.setPixels(arrayOfInt, 0, i, 0, 0, i, j);
    return bitmap;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */