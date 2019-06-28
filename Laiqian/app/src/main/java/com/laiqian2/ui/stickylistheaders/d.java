package com.laiqian.ui.stickylistheaders;

import android.database.DataSetObserver;

class d extends DataSetObserver {
  d(StickyListHeadersListView paramStickyListHeadersListView) {}
  
  public void onChanged() {
    StickyListHeadersListView.access$002(this.dDI, true);
    StickyListHeadersListView.access$102(this.dDI, null);
  }
  
  public void onInvalidated() {
    StickyListHeadersListView.access$102(this.dDI, null);
    StickyListHeadersListView.access$200(this.dDI).asl();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\stickylistheaders\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */