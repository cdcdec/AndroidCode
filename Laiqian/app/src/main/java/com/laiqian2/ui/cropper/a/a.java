package com.laiqian.ui.cropper.a;

import android.graphics.Rect;

public class a {
  public static float d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) { return (paramFloat3 - paramFloat1) / (paramFloat4 - paramFloat2); }
  
  public static float e(float paramFloat1, float paramFloat2, float paramFloat3) { return paramFloat3 * (paramFloat2 - paramFloat1); }
  
  public static float e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) { return paramFloat2 - paramFloat4 * (paramFloat3 - paramFloat1); }
  
  public static float f(float paramFloat1, float paramFloat2, float paramFloat3) { return (paramFloat2 - paramFloat1) / paramFloat3; }
  
  public static float f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) { return paramFloat3 - (paramFloat2 - paramFloat1) / paramFloat4; }
  
  public static float g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) { return paramFloat4 * (paramFloat3 - paramFloat2) + paramFloat1; }
  
  public static float h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) { return (paramFloat3 - paramFloat1) / paramFloat4 + paramFloat2; }
  
  public static float p(Rect paramRect) { return paramRect.width() / paramRect.height(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */