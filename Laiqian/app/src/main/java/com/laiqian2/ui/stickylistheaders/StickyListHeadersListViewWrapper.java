package com.laiqian.ui.stickylistheaders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.a.a.a.a.a.a;
import java.lang.reflect.Field;

public class StickyListHeadersListViewWrapper extends FrameLayout {
  private static final boolean dDJ;
  
  private static Field dDK;
  
  private static Field dDL;
  
  private int dDM;
  
  private Drawable dDN;
  
  private ViewConfiguration dDO;
  
  private boolean dDP;
  
  private Rect dDQ;
  
  private View.OnTouchListener dDR;
  
  private ViewTreeObserver.OnGlobalLayoutListener dDS;
  
  private boolean dDT;
  
  private boolean dDU;
  
  private final GestureDetector dDk;
  
  private boolean drawSelectorOnTop;
  
  private View header;
  
  static  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    } else {
      bool = false;
    } 
    dDJ = bool;
  }
  
  public StickyListHeadersListViewWrapper(Context paramContext) { this(paramContext, null, 0); }
  
  public StickyListHeadersListViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = null;
    this.header = null;
    this.dDM = -1;
    this.drawSelectorOnTop = false;
    this.dDQ = new Rect();
    this.dDR = new h(this);
    this.dDS = new i(this);
    if (!isInEditMode())
      gestureDetector = new GestureDetector(paramContext, new a(this, null)); 
    this.dDk = gestureDetector;
    if (!dDJ)
      try {
        dDK = View.class.getDeclaredField("mTop");
        dDL = View.class.getDeclaredField("mBottom");
        dDK.setAccessible(true);
        dDL.setAccessible(true);
      } catch (NoSuchFieldException gestureDetector) {
        a.e(gestureDetector);
      }  
    this.dDO = ViewConfiguration.get(paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(this.dDS);
  }
  
  private Rect asp() {
    this.dDQ.left = this.header.getLeft();
    this.dDQ.top = this.dDM - this.header.getHeight();
    this.dDQ.right = this.header.getRight();
    this.dDQ.bottom = this.dDM;
    return this.dDQ;
  }
  
  private void q(Canvas paramCanvas) {
    this.dDN.setBounds(asp());
    int[] arrayOfInt = this.dDN.getState();
    this.dDN.setState(this.header.getDrawableState());
    this.dDN.draw(paramCanvas);
    this.dDN.setState(arrayOfInt);
  }
  
  View asl() {
    if (this.header != null) {
      if (this.dDT) {
        this.dDU = true;
      } else {
        removeView(this.header);
      } 
      this.header.setOnTouchListener(null);
    } 
    View view = this.header;
    this.header = null;
    return view;
  }
  
  boolean asm() { return (this.header != null); }
  
  int asn() {
    null = this.header;
    int i = 0;
    if (null == null)
      return 0; 
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.header.getLayoutParams();
    int j = getMeasuredWidth();
    if (marginLayoutParams != null)
      i = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin; 
    i = View.MeasureSpec.makeMeasureSpec(j - i, 1073741824);
    j = View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824);
    measureChild(this.header, i, j);
    return this.header.getMeasuredHeight();
  }
  
  int aso() { return this.dDM; }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    if (this.dDN != null && this.dDP && !this.drawSelectorOnTop)
      q(paramCanvas); 
    super.dispatchDraw(paramCanvas);
    if (this.dDN != null && this.dDP && this.drawSelectorOnTop)
      q(paramCanvas); 
  }
  
  boolean dv(View paramView) { return (this.header == paramView); }
  
  void dw(View paramView) {
    if (paramView == this.header)
      return; 
    if (this.header != null)
      throw new IllegalStateException("You must first remove the old header first"); 
    this.header = paramView;
    if (paramView != null) {
      View view = getChildAt(0);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getMeasuredWidth() - view.getPaddingLeft() - view.getPaddingRight(), -2);
      layoutParams.leftMargin = view.getPaddingLeft();
      layoutParams.rightMargin = view.getPaddingRight();
      layoutParams.gravity = 48;
      paramView.setLayoutParams(layoutParams);
      paramView.setOnTouchListener(this.dDR);
      if (this.dDT) {
        this.dDU = true;
        return;
      } 
      addView(paramView);
    } 
  }
  
  @SuppressLint({"NewApi"})
  void lq(int paramInt) {
    if (this.header != null)
      if (dDJ) {
        this.header.setTranslationY((paramInt - this.header.getMeasuredHeight()));
      } else {
        try {
          dDK.set(this.header, Integer.valueOf(paramInt - this.header.getMeasuredHeight()));
          dDL.set(this.header, Integer.valueOf(paramInt));
        } catch (IllegalArgumentException illegalArgumentException) {
          a.e(illegalArgumentException);
        } catch (IllegalAccessException illegalAccessException) {
          a.e(illegalAccessException);
        } 
      }  
    this.dDM = paramInt;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.dDT = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    lq(this.dDM);
    this.dDT = false;
  }
  
  public void setDrawSelectorOnTop(boolean paramBoolean) { this.drawSelectorOnTop = paramBoolean; }
  
  public void setSelector(Drawable paramDrawable) { this.dDN = paramDrawable; }
  
  private class a extends GestureDetector.SimpleOnGestureListener {
    private a(StickyListHeadersListViewWrapper this$0) {}
    
    public void onShowPress(MotionEvent param1MotionEvent) {
      StickyListHeadersListViewWrapper.a(this.dDW, true);
      this.dDW.invalidate(StickyListHeadersListViewWrapper.a(this.dDW));
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\stickylistheaders\StickyListHeadersListViewWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */