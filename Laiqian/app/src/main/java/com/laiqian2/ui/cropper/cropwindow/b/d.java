package com.laiqian.ui.cropper.cropwindow.b;

import android.graphics.Rect;
import com.laiqian.ui.cropper.a.a;
import com.laiqian.ui.cropper.cropwindow.a.a;
import com.laiqian.ui.cropper.cropwindow.a.c;

abstract class d {
  private a dyX;
  
  private a dyY;
  
  private c dyZ;
  
  d(a parama1, a parama2) {
    this.dyX = parama1;
    this.dyY = parama2;
    this.dyZ = new c(this.dyX, this.dyY);
  }
  
  private float j(float paramFloat1, float paramFloat2) {
    float f2;
    float f1;
    if (this.dyY == a.dyD) {
      f1 = paramFloat1;
    } else {
      f1 = a.dyD.ard();
    } 
    if (this.dyX == a.dyE) {
      f2 = paramFloat2;
    } else {
      f2 = a.dyE.ard();
    } 
    if (this.dyY != a.dyF)
      paramFloat1 = a.dyF.ard(); 
    if (this.dyX != a.dyG)
      paramFloat2 = a.dyG.ard(); 
    return a.d(f1, f2, paramFloat1, paramFloat2);
  }
  
  abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4);
  
  void a(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3) {
    null = are();
    a a1 = null.dyK;
    a a2 = null.dyL;
    if (a1 != null)
      a1.a(paramFloat1, paramFloat2, paramRect, paramFloat3, 1.0F); 
    if (a2 != null)
      a2.a(paramFloat1, paramFloat2, paramRect, paramFloat3, 1.0F); 
  }
  
  c are() { return this.dyZ; }
  
  c d(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (j(paramFloat1, paramFloat2) > paramFloat3) {
      this.dyZ.dyK = this.dyY;
      this.dyZ.dyL = this.dyX;
    } else {
      this.dyZ.dyK = this.dyX;
      this.dyZ.dyL = this.dyY;
    } 
    return this.dyZ;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\cropwindow\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */