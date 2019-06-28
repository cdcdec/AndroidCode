package com.laiqian.util;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.EnumMap;

public class ac {
  public static final String TAG = "ac";
  
  private final MultiFormatReader dFj = new MultiFormatReader();
  
  static  {
  
  }
  
  private ac(a parama) {
    EnumMap enumMap = new EnumMap(DecodeHintType.class);
    ArrayList arrayList = new ArrayList();
    arrayList.add(BarcodeFormat.QR_CODE);
    enumMap.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
    enumMap.put(DecodeHintType.CHARACTER_SET, a.a(parama));
    this.dFj.setHints(enumMap);
  }
  
  public String u(Bitmap paramBitmap) {
    long l = System.currentTimeMillis();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int[] arrayOfInt = new int[i * j];
    paramBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    binaryBitmap = new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(i, j, arrayOfInt)));
    try {
      Result result = this.dFj.decodeWithState(binaryBitmap);
      long l1 = System.currentTimeMillis();
      String str2 = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("QRCode decode in ");
      stringBuilder.append(l1 - l);
      stringBuilder.append("ms");
      Log.d(str2, stringBuilder.toString());
      Log.d(TAG, result.toString());
      String str1 = result.getText();
      this.dFj.reset();
      return str1;
    } catch (NotFoundException binaryBitmap) {
      Log.w(TAG, binaryBitmap);
      this.dFj.reset();
      return null;
    } finally {}
    this.dFj.reset();
    throw binaryBitmap;
  }
  
  public static class a {
    private String dFk = "UTF-8";
    
    public ac asP() { return new ac(this, null); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */