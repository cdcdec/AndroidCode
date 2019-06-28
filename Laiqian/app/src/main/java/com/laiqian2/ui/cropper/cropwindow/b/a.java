package com.laiqian.ui.cropper.cropwindow.b;

import android.graphics.Rect;
import com.laiqian.ui.cropper.cropwindow.a.a;

class a extends d {
  a() { super(null, null); }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4) { a(paramFloat1, paramFloat2, paramRect, paramFloat4); }
  
  void a(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3) {
    float f3 = a.dyD.ard();
    float f1 = a.dyE.ard();
    float f4 = a.dyF.ard();
    float f2 = a.dyG.ard();
    f3 = (f3 + f4) / 2.0F;
    f1 = (f1 + f2) / 2.0F;
    paramFloat1 -= f3;
    paramFloat2 -= f1;
    a.dyD.w(paramFloat1);
    a.dyE.w(paramFloat2);
    a.dyF.w(paramFloat1);
    a.dyG.w(paramFloat2);
    if (a.dyD.a(paramRect, paramFloat3)) {
      paramFloat1 = a.dyD.n(paramRect);
      a.dyF.w(paramFloat1);
    } else if (a.dyF.a(paramRect, paramFloat3)) {
      paramFloat1 = a.dyF.n(paramRect);
      a.dyD.w(paramFloat1);
    } 
    if (a.dyE.a(paramRect, paramFloat3)) {
      paramFloat1 = a.dyE.n(paramRect);
      a.dyG.w(paramFloat1);
      return;
    } 
    if (a.dyG.a(paramRect, paramFloat3)) {
      paramFloat1 = a.dyG.n(paramRect);
      a.dyE.w(paramFloat1);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\cropwindow\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */