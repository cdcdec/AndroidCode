package com.laiqian.pos.listview;

import android.database.DataSetObserver;

class a extends DataSetObserver {
  a(HorizontalListView paramHorizontalListView) {}
  
  public void onChanged() {
    synchronized (this.cyv) {
      HorizontalListView.a(this.cyv, true);
      this.cyv.invalidate();
      this.cyv.requestLayout();
      return;
    } 
  }
  
  public void onInvalidated() {
    HorizontalListView.a(this.cyv);
    this.cyv.invalidate();
    this.cyv.requestLayout();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\listview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */