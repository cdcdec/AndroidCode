package com.laiqian.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.File;

public class j {
  public static Bitmap G(File paramFile) { return BitmapFactory.decodeFile(paramFile.getAbsolutePath()); }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat) {
    Matrix matrix = new Matrix();
    matrix.postScale(paramFloat, paramFloat);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), matrix, true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */