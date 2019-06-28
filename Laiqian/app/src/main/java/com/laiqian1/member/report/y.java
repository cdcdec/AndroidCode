package com.laiqian.member.report;

import com.laiqian.basic.RootApplication;
import com.laiqian.ui.listview.FormListView;

class y implements FormListView.a {
  y(VipReportActivity paramVipReportActivity) {}
  
  public void aX(int paramInt1, int paramInt2) {
    if (VipReportActivity.f(this.bzE) != null && VipReportActivity.f(this.bzE).isShowing())
      VipReportActivity.f(this.bzE).dismiss(); 
    if (paramInt2 == 0) {
      if (paramInt1 == 0) {
        if (RootApplication.getLaiqianPreferenceManager().Wq()) {
          this.bzE.bqN.setVisibility(0);
          VipReportActivity.g(this.bzE).setVisibility(8);
          this.bzE.bzv.setVisibility(8);
        } else {
          VipReportActivity.g(this.bzE).setVisibility(0);
          this.bzE.bqN.setVisibility(8);
          this.bzE.bzv.setVisibility(8);
        } 
        VipReportActivity.d(this.bzE).hideFooterView();
        VipReportActivity.d(this.bzE).setVisibility(8);
        this.bzE.bzw.setVisibility(8);
        return;
      } 
      if (paramInt1 > 0 && paramInt1 < 10) {
        VipReportActivity.d(this.bzE).hideFooterView();
        this.bzE.bzw.setVisibility(0);
        VipReportActivity.d(this.bzE).setVisibility(0);
        VipReportActivity.g(this.bzE).setVisibility(8);
        this.bzE.bqN.setVisibility(8);
        this.bzE.bzv.setVisibility(8);
        return;
      } 
      if (paramInt1 >= 10) {
        VipReportActivity.d(this.bzE).showFooterView();
        VipReportActivity.d(this.bzE).setVisibility(0);
        this.bzE.bzw.setVisibility(0);
        VipReportActivity.g(this.bzE).setVisibility(8);
        this.bzE.bqN.setVisibility(8);
        this.bzE.bzv.setVisibility(8);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */