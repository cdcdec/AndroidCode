package com.laiqian.report.onlinepay;

import com.laiqian.ui.listview.FormListView;

class f implements FormListView.a {
  f(OnlinePayReportActivity paramOnlinePayReportActivity) {}
  
  public void aX(int paramInt1, int paramInt2) {
    this.ddj.hideProgress();
    if (paramInt2 == 0) {
      if (paramInt1 == 0) {
        OnlinePayReportActivity.a(this.ddj).setVisibility(0);
        this.ddj.bqN.setVisibility(8);
        OnlinePayReportActivity.b(this.ddj).hideFooterView();
        OnlinePayReportActivity.b(this.ddj).setVisibility(8);
        this.ddj.bzw.setVisibility(8);
        return;
      } 
      if (paramInt1 > 0 && paramInt1 < 10) {
        OnlinePayReportActivity.b(this.ddj).hideFooterView();
        this.ddj.bzw.setVisibility(0);
        OnlinePayReportActivity.b(this.ddj).setVisibility(0);
        OnlinePayReportActivity.a(this.ddj).setVisibility(8);
        this.ddj.bqN.setVisibility(8);
        return;
      } 
      if (paramInt1 >= 10) {
        OnlinePayReportActivity.b(this.ddj).showFooterView();
        OnlinePayReportActivity.b(this.ddj).setVisibility(0);
        this.ddj.bzw.setVisibility(0);
        OnlinePayReportActivity.a(this.ddj).setVisibility(8);
        this.ddj.bqN.setVisibility(8);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */