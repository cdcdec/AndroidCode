package com.laiqian.member.report;

import android.view.View;

class w implements View.OnClickListener {
  w(VipReportActivity paramVipReportActivity) {}
  
  public void onClick(View paramView) {
    if (!VipReportActivity.u(this.bzE).isSelected())
      VipReportActivity.t(this.bzE).gn(-1); 
    VipReportActivity.t(this.bzE).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */