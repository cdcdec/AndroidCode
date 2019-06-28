package com.laiqian.ui.cropper.cropwindow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.laiqian.ui.cropper.a.a;
import com.laiqian.ui.cropper.a.b;
import com.laiqian.ui.cropper.a.e;
import com.laiqian.ui.cropper.cropwindow.a.a;
import com.laiqian.ui.cropper.cropwindow.b.c;

public class CropOverlayView extends View {
  private static final float dyl = e.arh();
  
  private static final float dym = e.ari();
  
  private static final float dyn = dyl / 2.0F - dym / 2.0F;
  
  private static final float dyo = dyl / 2.0F + dyn;
  
  private float dyA;
  
  private float dyB;
  
  private float dyC;
  
  private int dyg;
  
  private boolean dyh = false;
  
  private int dyi = 1;
  
  private int dyj = 1;
  
  private Paint dyp;
  
  private Paint dyq;
  
  private Paint dyr;
  
  private Paint dys;
  
  private Rect dyt;
  
  private float dyu;
  
  private float dyv;
  
  private Pair<Float, Float> dyw;
  
  private c dyx;
  
  private float dyy = this.dyi / this.dyj;
  
  private boolean dyz = false;
  
  public CropOverlayView(Context paramContext) {
    super(paramContext);
    init(paramContext);
  }
  
  public CropOverlayView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect) {
    float f1 = a.dyD.ard();
    float f2 = a.dyE.ard();
    float f3 = a.dyF.ard();
    float f4 = a.dyG.ard();
    paramCanvas.drawRect(paramRect.left, paramRect.top, paramRect.right, f2, this.dys);
    paramCanvas.drawRect(paramRect.left, f4, paramRect.right, paramRect.bottom, this.dys);
    paramCanvas.drawRect(paramRect.left, f2, f1, f4, this.dys);
    paramCanvas.drawRect(f3, f2, paramRect.right, f4, this.dys);
  }
  
  public static boolean arb() { return !(Math.abs(a.dyD.ard() - a.dyF.ard()) < 100.0F || Math.abs(a.dyE.ard() - a.dyG.ard()) < 100.0F); }
  
  private void arc() {
    if (this.dyx == null)
      return; 
    this.dyx = null;
    invalidate();
  }
  
  private void h(float paramFloat1, float paramFloat2) {
    float f1 = a.dyD.ard();
    float f2 = a.dyE.ard();
    float f3 = a.dyF.ard();
    float f4 = a.dyG.ard();
    this.dyx = b.a(paramFloat1, paramFloat2, f1, f2, f3, f4, this.dyu);
    if (this.dyx == null)
      return; 
    this.dyw = b.a(this.dyx, paramFloat1, paramFloat2, f1, f2, f3, f4);
    invalidate();
  }
  
  private void i(float paramFloat1, float paramFloat2) {
    if (this.dyx == null)
      return; 
    paramFloat1 += ((Float)this.dyw.first).floatValue();
    paramFloat2 += ((Float)this.dyw.second).floatValue();
    if (this.dyh) {
      this.dyx.a(paramFloat1, paramFloat2, this.dyy, this.dyt, this.dyv);
    } else {
      this.dyx.a(paramFloat1, paramFloat2, this.dyt, this.dyv);
    } 
    invalidate();
  }
  
  private void init(Context paramContext) {
    DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
    this.dyu = b.bC(paramContext);
    this.dyv = TypedValue.applyDimension(1, 6.0F, displayMetrics);
    this.dyp = e.bD(paramContext);
    this.dyq = e.arg();
    this.dys = e.bE(paramContext);
    this.dyr = e.bF(paramContext);
    this.dyB = TypedValue.applyDimension(1, dyn, displayMetrics);
    this.dyA = TypedValue.applyDimension(1, dyo, displayMetrics);
    this.dyC = TypedValue.applyDimension(1, 20.0F, displayMetrics);
    this.dyg = 1;
  }
  
  private void m(Canvas paramCanvas) {
    float f1 = a.dyD.ard();
    float f4 = a.dyE.ard();
    float f2 = a.dyF.ard();
    float f3 = a.dyG.ard();
    float f5 = a.getWidth() / 3.0F;
    float f6 = f1 + f5;
    paramCanvas.drawLine(f6, f4, f6, f3, this.dyq);
    f5 = f2 - f5;
    paramCanvas.drawLine(f5, f4, f5, f3, this.dyq);
    f5 = a.getHeight() / 3.0F;
    f4 += f5;
    paramCanvas.drawLine(f1, f4, f2, f4, this.dyq);
    f3 -= f5;
    paramCanvas.drawLine(f1, f3, f2, f3, this.dyq);
  }
  
  private void m(Rect paramRect) {
    if (!this.dyz)
      this.dyz = true; 
    if (this.dyh) {
      if (a.p(paramRect) > this.dyy) {
        a.dyE.v(paramRect.top);
        a.dyG.v(paramRect.bottom);
        float f5 = getWidth() / 2.0F;
        float f6 = Math.max(40.0F, a.e(a.dyE.ard(), a.dyG.ard(), this.dyy));
        if (f6 == 40.0F)
          this.dyy = 40.0F / (a.dyG.ard() - a.dyE.ard()); 
        f6 /= 2.0F;
        a.dyD.v(f5 - f6);
        a.dyF.v(f5 + f6);
        return;
      } 
      a.dyD.v(paramRect.left);
      a.dyF.v(paramRect.right);
      float f3 = getHeight() / 2.0F;
      float f4 = Math.max(40.0F, a.f(a.dyD.ard(), a.dyF.ard(), this.dyy));
      if (f4 == 40.0F)
        this.dyy = (a.dyF.ard() - a.dyD.ard()) / 40.0F; 
      f4 /= 2.0F;
      a.dyE.v(f3 - f4);
      a.dyG.v(f3 + f4);
      return;
    } 
    float f1 = paramRect.width() * 0.1F;
    float f2 = paramRect.height() * 0.1F;
    a.dyD.v(paramRect.left + f1);
    a.dyE.v(paramRect.top + f2);
    a.dyF.v(paramRect.right - f1);
    a.dyG.v(paramRect.bottom - f2);
  }
  
  private void n(Canvas paramCanvas) {
    float f1 = a.dyD.ard();
    float f2 = a.dyE.ard();
    float f3 = a.dyF.ard();
    float f4 = a.dyG.ard();
    paramCanvas.drawLine(f1 - this.dyB, f2 - this.dyA, f1 - this.dyB, f2 + this.dyC, this.dyr);
    paramCanvas.drawLine(f1, f2 - this.dyB, f1 + this.dyC, f2 - this.dyB, this.dyr);
    paramCanvas.drawLine(f3 + this.dyB, f2 - this.dyA, f3 + this.dyB, f2 + this.dyC, this.dyr);
    paramCanvas.drawLine(f3, f2 - this.dyB, f3 - this.dyC, f2 - this.dyB, this.dyr);
    paramCanvas.drawLine(f1 - this.dyB, f4 + this.dyA, f1 - this.dyB, f4 - this.dyC, this.dyr);
    paramCanvas.drawLine(f1, f4 + this.dyB, f1 + this.dyC, f4 + this.dyB, this.dyr);
    paramCanvas.drawLine(f3 + this.dyB, f4 + this.dyA, f3 + this.dyB, f4 - this.dyC, this.dyr);
    paramCanvas.drawLine(f3, f4 + this.dyB, f3 - this.dyC, f4 + this.dyB, this.dyr);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
    if (paramInt1 < 0 || paramInt1 > 2)
      throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation."); 
    this.dyg = paramInt1;
    this.dyh = paramBoolean;
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0."); 
    this.dyi = paramInt2;
    this.dyy = this.dyi / this.dyj;
    if (paramInt3 <= 0)
      throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0."); 
    this.dyj = paramInt3;
    this.dyy = this.dyi / this.dyj;
  }
  
  public void ara() {
    if (this.dyz) {
      m(this.dyt);
      invalidate();
    } 
  }
  
  public void hd(boolean paramBoolean) {
    this.dyh = paramBoolean;
    if (this.dyz) {
      m(this.dyt);
      invalidate();
    } 
  }
  
  public void kJ(int paramInt) {
    if (paramInt < 0 || paramInt > 2)
      throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation."); 
    this.dyg = paramInt;
    if (this.dyz) {
      m(this.dyt);
      invalidate();
    } 
  }
  
  public void kL(int paramInt) {
    if (paramInt <= 0)
      throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0."); 
    this.dyi = paramInt;
    this.dyy = this.dyi / this.dyj;
    if (this.dyz) {
      m(this.dyt);
      invalidate();
    } 
  }
  
  public void kM(int paramInt) {
    if (paramInt <= 0)
      throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0."); 
    this.dyj = paramInt;
    this.dyy = this.dyi / this.dyj;
    if (this.dyz) {
      m(this.dyt);
      invalidate();
    } 
  }
  
  public void l(Rect paramRect) {
    this.dyt = paramRect;
    m(this.dyt);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    a(paramCanvas, this.dyt);
    if (arb())
      if (this.dyg == 2) {
        m(paramCanvas);
      } else if (this.dyg == 1) {
        if (this.dyx != null)
          m(paramCanvas); 
      } else {
        int i = this.dyg;
      }  
    paramCanvas.drawRect(a.dyD.ard(), a.dyE.ard(), a.dyF.ard(), a.dyG.ard(), this.dyp);
    n(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { m(this.dyt); }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!isEnabled())
      return false; 
    switch (paramMotionEvent.getAction()) {
      default:
        return false;
      case 2:
        i(paramMotionEvent.getX(), paramMotionEvent.getY());
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
      case 1:
      case 3:
        getParent().requestDisallowInterceptTouchEvent(false);
        arc();
        return true;
      case 0:
        break;
    } 
    h(paramMotionEvent.getX(), paramMotionEvent.getY());
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\cropwindow\CropOverlayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */