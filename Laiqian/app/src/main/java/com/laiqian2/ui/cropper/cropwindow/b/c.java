package com.laiqian.ui.cropper.cropwindow.b;

import android.graphics.Rect;
import com.laiqian.ui.cropper.cropwindow.a.a;

public static enum c {
  dyM(new b(a.dyE, a.dyD)),
  dyN(new b(a.dyE, a.dyF)),
  dyO(new b(a.dyG, a.dyD)),
  dyP(new b(a.dyG, a.dyF)),
  dyQ(new f(a.dyD)),
  dyR(new e(a.dyE)),
  dyS(new f(a.dyF)),
  dyT(new e(a.dyG)),
  dyU(new a());
  
  private d dyV;
  
  c(d paramd1) { this.dyV = paramd1; }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4) { this.dyV.a(paramFloat1, paramFloat2, paramFloat3, paramRect, paramFloat4); }
  
  public void a(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3) { this.dyV.a(paramFloat1, paramFloat2, paramRect, paramFloat3); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\cropwindow\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */