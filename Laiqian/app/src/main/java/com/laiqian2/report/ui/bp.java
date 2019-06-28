package com.laiqian.report.ui;

import android.widget.AbsListView;
import com.laiqian.util.n;

class bp implements AbsListView.OnScrollListener {
  boolean dgO;
  
  bp(ReportRoot paramReportRoot) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    boolean bool;
    if (paramInt1 + paramInt2 == paramInt3) {
      bool = true;
    } else {
      bool = false;
    } 
    this.dgO = bool;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    if (paramInt == 0 && n.b(this.dgN.bWY).getCount() > 0 && this.dgO) {
      this.dgO = false;
      this.dgN.aoh();
      this.dgN.aog();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */