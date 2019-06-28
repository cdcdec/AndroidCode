package com.laiqian.ui.cropper.cropwindow.b;

import android.graphics.Rect;
import com.laiqian.ui.cropper.cropwindow.a.a;
import com.laiqian.ui.cropper.cropwindow.a.c;

class b extends d {
  b(a parama1, a parama2) { super(parama1, parama2); }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4) {
    null = d(paramFloat1, paramFloat2, paramFloat3);
    a a1 = null.dyK;
    a a2 = null.dyL;
    a1.a(paramFloat1, paramFloat2, paramRect, paramFloat4, paramFloat3);
    a2.A(paramFloat3);
    if (a2.a(paramRect, paramFloat4)) {
      a2.n(paramRect);
      a1.A(paramFloat3);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\cropwindow\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */