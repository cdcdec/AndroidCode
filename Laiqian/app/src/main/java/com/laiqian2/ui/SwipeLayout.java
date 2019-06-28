package com.laiqian.ui;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class SwipeLayout extends SwipeRefreshLayout {
  ViewGroup dhd;
  
  public SwipeLayout(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.dhd != null && this.dhd.getScrollY() > 1) {
      setEnabled(false);
      return super.onTouchEvent(paramMotionEvent);
    } 
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\SwipeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */