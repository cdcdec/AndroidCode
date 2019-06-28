package com.laiqian.pos;

import android.widget.AbsListView;

class ct implements AbsListView.OnScrollListener {
  ct(ReprintActivity paramReprintActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    if (paramInt != 0)
      return; 
    ReprintActivity.e(this.cik);
    if (paramAbsListView.getLastVisiblePosition() == ReprintActivity.a(this.cik).getCount() + (ReprintActivity.b(this.cik)).bLC.getFooterViewsCount() - 1) {
      if (ReprintActivity.f(this.cik) > ReprintActivity.g(this.cik))
        return; 
      if (ReprintActivity.h(this.cik))
        return; 
      ReprintActivity.i(this.cik);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */