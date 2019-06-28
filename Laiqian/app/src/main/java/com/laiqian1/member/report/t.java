package com.laiqian.member.report;

import android.view.View;

class t implements View.OnClickListener {
  t(VipReportActivity paramVipReportActivity) {}
  
  public void onClick(View paramView) {
    if (!paramView.isSelected())
      VipReportActivity.s(this.bzE).gn(-1); 
    VipReportActivity.s(this.bzE).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */