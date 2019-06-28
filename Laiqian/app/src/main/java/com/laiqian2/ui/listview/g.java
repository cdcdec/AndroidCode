package com.laiqian.ui.listview;

import android.database.DataSetObserver;

class g extends DataSetObserver {
  g(HorizontalListView paramHorizontalListView) {}
  
  public void onChanged() {
    HorizontalListView.a(this.dCs, true);
    HorizontalListView.b(this.dCs, false);
    HorizontalListView.b(this.dCs);
    this.dCs.invalidate();
    this.dCs.requestLayout();
  }
  
  public void onInvalidated() {
    HorizontalListView.b(this.dCs, false);
    HorizontalListView.b(this.dCs);
    HorizontalListView.c(this.dCs);
    this.dCs.invalidate();
    this.dCs.requestLayout();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */