package com.laiqian.ui.cropper.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;

public class e {
  public static Paint arg() {
    Paint paint = new Paint();
    paint.setColor(Color.parseColor("#AAFFFFFF"));
    paint.setStrokeWidth(1.0F);
    return paint;
  }
  
  public static float arh() { return 5.0F; }
  
  public static float ari() { return 3.0F; }
  
  public static Paint bD(Context paramContext) {
    float f = TypedValue.applyDimension(1, 3.0F, paramContext.getResources().getDisplayMetrics());
    Paint paint = new Paint();
    paint.setColor(Color.parseColor("#AAFFFFFF"));
    paint.setStrokeWidth(f);
    paint.setStyle(Paint.Style.STROKE);
    return paint;
  }
  
  public static Paint bE(Context paramContext) {
    Paint paint = new Paint();
    paint.setColor(Color.parseColor("#B0000000"));
    return paint;
  }
  
  public static Paint bF(Context paramContext) {
    float f = TypedValue.applyDimension(1, 5.0F, paramContext.getResources().getDisplayMetrics());
    Paint paint = new Paint();
    paint.setColor(-1);
    paint.setStrokeWidth(f);
    paint.setStyle(Paint.Style.STROKE);
    return paint;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */