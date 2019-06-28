package com.laiqian.ui.cropper.cropwindow.b;

import android.graphics.Rect;
import com.laiqian.ui.cropper.a.a;
import com.laiqian.ui.cropper.cropwindow.a.a;

class e extends d {
  private a dza;
  
  e(a parama) {
    super(parama, null);
    this.dza = parama;
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4) {
    this.dza.a(paramFloat1, paramFloat2, paramRect, paramFloat4, paramFloat3);
    paramFloat1 = a.dyD.ard();
    float f = a.dyE.ard();
    paramFloat2 = a.dyF.ard();
    f = (a.e(f, a.dyG.ard(), paramFloat3) - paramFloat2 - paramFloat1) / 2.0F;
    a.dyD.v(paramFloat1 - f);
    a.dyF.v(paramFloat2 + f);
    if (a.dyD.a(paramRect, paramFloat4) && !this.dza.a(a.dyD, paramRect, paramFloat3)) {
      paramFloat1 = a.dyD.n(paramRect);
      a.dyF.w(-paramFloat1);
      this.dza.A(paramFloat3);
    } 
    if (a.dyF.a(paramRect, paramFloat4) && !this.dza.a(a.dyF, paramRect, paramFloat3)) {
      paramFloat1 = a.dyF.n(paramRect);
      a.dyD.w(-paramFloat1);
      this.dza.A(paramFloat3);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\cropwindow\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */