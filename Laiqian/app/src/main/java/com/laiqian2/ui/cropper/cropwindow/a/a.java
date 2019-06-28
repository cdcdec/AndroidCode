package com.laiqian.ui.cropper.cropwindow.a;

import android.graphics.Rect;
import com.laiqian.ui.cropper.a.a;

public static enum a {
  dyD, dyE, dyF, dyG;
  
  private float dyH;
  
  private static float a(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3) {
    if (paramFloat1 - paramRect.left < paramFloat2)
      return paramRect.left; 
    paramFloat2 = dyF.ard();
    float f = Float.POSITIVE_INFINITY;
    if (paramFloat1 >= paramFloat2 - 40.0F) {
      paramFloat2 = dyF.ard() - 40.0F;
    } else {
      paramFloat2 = Float.POSITIVE_INFINITY;
    } 
    if ((dyF.ard() - paramFloat1) / paramFloat3 <= 40.0F)
      f = dyF.ard() - paramFloat3 * 40.0F; 
    return Math.min(paramFloat1, Math.min(paramFloat2, f));
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Rect paramRect) { return (paramFloat1 < paramRect.top || paramFloat2 < paramRect.left || paramFloat3 > paramRect.bottom || paramFloat4 > paramRect.right); }
  
  private static float b(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3) {
    if (paramRect.right - paramFloat1 < paramFloat2)
      return paramRect.right; 
    paramFloat2 = dyD.ard();
    float f = Float.NEGATIVE_INFINITY;
    if (paramFloat1 <= paramFloat2 + 40.0F) {
      paramFloat2 = dyD.ard() + 40.0F;
    } else {
      paramFloat2 = Float.NEGATIVE_INFINITY;
    } 
    if ((paramFloat1 - dyD.ard()) / paramFloat3 <= 40.0F)
      f = dyD.ard() + paramFloat3 * 40.0F; 
    return Math.max(paramFloat1, Math.max(paramFloat2, f));
  }
  
  private static float c(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3) {
    if (paramFloat1 - paramRect.top < paramFloat2)
      return paramRect.top; 
    paramFloat2 = dyG.ard();
    float f = Float.POSITIVE_INFINITY;
    if (paramFloat1 >= paramFloat2 - 40.0F) {
      paramFloat2 = dyG.ard() - 40.0F;
    } else {
      paramFloat2 = Float.POSITIVE_INFINITY;
    } 
    if ((dyG.ard() - paramFloat1) * paramFloat3 <= 40.0F)
      f = dyG.ard() - 40.0F / paramFloat3; 
    return Math.min(paramFloat1, Math.min(paramFloat2, f));
  }
  
  private static float d(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3) {
    if (paramRect.bottom - paramFloat1 < paramFloat2)
      return paramRect.bottom; 
    paramFloat2 = dyE.ard();
    float f = Float.NEGATIVE_INFINITY;
    if (paramFloat1 <= paramFloat2 + 40.0F) {
      paramFloat2 = dyE.ard() + 40.0F;
    } else {
      paramFloat2 = Float.NEGATIVE_INFINITY;
    } 
    if ((paramFloat1 - dyE.ard()) * paramFloat3 <= 40.0F)
      f = dyE.ard() + 40.0F / paramFloat3; 
    return Math.max(paramFloat1, Math.max(f, paramFloat2));
  }
  
  public static float getHeight() { return dyG.ard() - dyE.ard(); }
  
  public static float getWidth() { return dyF.ard() - dyD.ard(); }
  
  public void A(float paramFloat) {
    float f1 = dyD.ard();
    float f2 = dyE.ard();
    float f3 = dyF.ard();
    float f4 = dyG.ard();
    switch (b.dyJ[ordinal()]) {
      default:
        return;
      case 4:
        this.dyH = a.h(f1, f2, f3, paramFloat);
        return;
      case 3:
        this.dyH = a.g(f1, f2, f4, paramFloat);
        return;
      case 2:
        this.dyH = a.f(f1, f3, f4, paramFloat);
        return;
      case 1:
        break;
    } 
    this.dyH = a.e(f2, f3, f4, paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3, float paramFloat4) {
    switch (b.dyJ[ordinal()]) {
      default:
        return;
      case 4:
        this.dyH = d(paramFloat2, paramRect, paramFloat3, paramFloat4);
        return;
      case 3:
        this.dyH = b(paramFloat1, paramRect, paramFloat3, paramFloat4);
        return;
      case 2:
        this.dyH = c(paramFloat2, paramRect, paramFloat3, paramFloat4);
        return;
      case 1:
        break;
    } 
    this.dyH = a(paramFloat1, paramRect, paramFloat3, paramFloat4);
  }
  
  public boolean a(Rect paramRect, float paramFloat) {
    switch (b.dyJ[ordinal()]) {
      default:
        return false;
      case 4:
        return (paramRect.bottom - this.dyH < paramFloat);
      case 3:
        return (paramRect.right - this.dyH < paramFloat);
      case 2:
        return (this.dyH - paramRect.top < paramFloat);
      case 1:
        break;
    } 
    return (this.dyH - paramRect.left < paramFloat);
  }
  
  public boolean a(a parama, Rect paramRect, float paramFloat) {
    float f = parama.o(paramRect);
    switch (b.dyJ[ordinal()]) {
      case 4:
        if (parama.equals(dyD)) {
          float f1 = paramRect.left;
          f = dyF.ard() - f;
          float f2 = dyE.ard();
          return a(f2, f1, a.h(f1, f2, f, paramFloat), f, paramRect);
        } 
        if (parama.equals(dyF)) {
          float f1 = paramRect.right;
          f = dyD.ard() - f;
          float f2 = dyE.ard();
          return a(f2, f, a.h(f, f2, f1, paramFloat), f1, paramRect);
        } 
        break;
      case 3:
        if (parama.equals(dyE)) {
          float f1 = paramRect.top;
          f = dyG.ard() - f;
          float f2 = dyD.ard();
          return a(f1, f2, f, a.g(f2, f1, f, paramFloat), paramRect);
        } 
        if (parama.equals(dyG)) {
          float f1 = paramRect.bottom;
          f = dyE.ard() - f;
          float f2 = dyD.ard();
          return a(f, f2, f1, a.g(f2, f, f1, paramFloat), paramRect);
        } 
        break;
      case 2:
        if (parama.equals(dyD)) {
          float f1 = paramRect.left;
          f = dyF.ard() - f;
          float f2 = dyG.ard();
          return a(a.f(f1, f, f2, paramFloat), f1, f2, f, paramRect);
        } 
        if (parama.equals(dyF)) {
          float f1 = paramRect.right;
          f = dyD.ard() - f;
          float f2 = dyG.ard();
          return a(a.f(f, f1, f2, paramFloat), f, f2, f1, paramRect);
        } 
        break;
      case 1:
        if (parama.equals(dyE)) {
          float f1 = paramRect.top;
          f = dyG.ard() - f;
          float f2 = dyF.ard();
          return a(f1, a.e(f1, f2, f, paramFloat), f, f2, paramRect);
        } 
        if (parama.equals(dyG)) {
          float f1 = paramRect.bottom;
          f = dyE.ard() - f;
          float f2 = dyF.ard();
          return a(f, a.e(f, f2, f1, paramFloat), f1, f2, paramRect);
        } 
        break;
    } 
    return true;
  }
  
  public float ard() { return this.dyH; }
  
  public float n(Rect paramRect) {
    float f = this.dyH;
    switch (b.dyJ[ordinal()]) {
      case 4:
        this.dyH = paramRect.bottom;
        break;
      case 3:
        this.dyH = paramRect.right;
        break;
      case 2:
        this.dyH = paramRect.top;
        break;
      case 1:
        this.dyH = paramRect.left;
        break;
    } 
    return this.dyH - f;
  }
  
  public float o(Rect paramRect) {
    float f2 = this.dyH;
    switch (b.dyJ[ordinal()]) {
      default:
        f1 = f2;
        return f1 - f2;
      case 4:
        f1 = paramRect.bottom;
        return f1 - f2;
      case 3:
        f1 = paramRect.right;
        return f1 - f2;
      case 2:
        f1 = paramRect.top;
        return f1 - f2;
      case 1:
        break;
    } 
    float f1 = paramRect.left;
    return f1 - f2;
  }
  
  public void v(float paramFloat) { this.dyH = paramFloat; }
  
  public void w(float paramFloat) { this.dyH += paramFloat; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\cropwindow\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */