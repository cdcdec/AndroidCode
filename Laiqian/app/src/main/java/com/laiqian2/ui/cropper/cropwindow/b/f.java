package com.laiqian.ui.cropper.cropwindow.b;

import android.graphics.Rect;
import com.laiqian.ui.cropper.a.a;
import com.laiqian.ui.cropper.cropwindow.a.a;

class f extends d {
  private a dza;
  
  f(a parama) {
    super(null, parama);
    this.dza = parama;
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4) {
    this.dza.a(paramFloat1, paramFloat2, paramRect, paramFloat4, paramFloat3);
    float f1 = a.dyD.ard();
    paramFloat1 = a.dyE.ard();
    float f2 = a.dyF.ard();
    paramFloat2 = a.dyG.ard();
    f1 = (a.f(f1, f2, paramFloat3) - paramFloat2 - paramFloat1) / 2.0F;
    a.dyE.v(paramFloat1 - f1);
    a.dyG.v(paramFloat2 + f1);
    if (a.dyE.a(paramRect, paramFloat4) && !this.dza.a(a.dyE, paramRect, paramFloat3)) {
      paramFloat1 = a.dyE.n(paramRect);
      a.dyG.w(-paramFloat1);
      this.dza.A(paramFloat3);
    } 
    if (a.dyG.a(paramRect, paramFloat4) && !this.dza.a(a.dyG, paramRect, paramFloat3)) {
      paramFloat1 = a.dyG.n(paramRect);
      a.dyE.w(-paramFloat1);
      this.dza.A(paramFloat3);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\cropwindow\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */