package com.laiqian.ui.stickylistheaders;

import android.view.ViewTreeObserver;

class i implements ViewTreeObserver.OnGlobalLayoutListener {
  i(StickyListHeadersListViewWrapper paramStickyListHeadersListViewWrapper) {}
  
  public void onGlobalLayout() {
    if (StickyListHeadersListViewWrapper.d(this.dDW)) {
      if (this.dDW.getChildCount() > 1)
        this.dDW.removeViewAt(1); 
      if (StickyListHeadersListViewWrapper.e(this.dDW) != null)
        this.dDW.addView(StickyListHeadersListViewWrapper.e(this.dDW)); 
    } 
    StickyListHeadersListViewWrapper.b(this.dDW, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\stickylistheaders\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */