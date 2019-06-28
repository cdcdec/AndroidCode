package com.laiqian.ui.scrollview;

import android.support.v4.widget.NestedScrollView;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class YCanScrollview extends NestedScrollView {
  GestureDetector dDk;
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) { return (super.onInterceptTouchEvent(paramMotionEvent) && this.dDk.onTouchEvent(paramMotionEvent)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\scrollview\YCanScrollview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */