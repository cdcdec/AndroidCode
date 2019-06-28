package com.laiqian.ui.stickylistheaders;

import android.view.MotionEvent;
import android.view.View;

class h implements View.OnTouchListener {
  float dDV;
  
  h(StickyListHeadersListViewWrapper paramStickyListHeadersListViewWrapper) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    boolean bool = true;
    if (i == 0) {
      this.dDV = paramMotionEvent.getY();
    } else if (paramMotionEvent.getAction() == 1) {
      StickyListHeadersListViewWrapper.a(this.dDW, false);
      this.dDW.invalidate(StickyListHeadersListViewWrapper.a(this.dDW));
    } 
    if (Math.abs(this.dDV - paramMotionEvent.getY()) <= StickyListHeadersListViewWrapper.b(this.dDW).getScaledTouchSlop())
      bool = false; 
    if (bool) {
      StickyListHeadersListViewWrapper.a(this.dDW, false);
      this.dDW.invalidate(StickyListHeadersListViewWrapper.a(this.dDW));
    } 
    StickyListHeadersListViewWrapper.c(this.dDW).onTouchEvent(paramMotionEvent);
    return bool;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\stickylistheaders\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */