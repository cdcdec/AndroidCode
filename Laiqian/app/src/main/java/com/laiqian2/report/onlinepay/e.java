package com.laiqian.report.onlinepay;

import android.view.View;

class e implements View.OnClickListener {
  e(OnlinePayReportActivity paramOnlinePayReportActivity) {}
  
  public void onClick(View paramView) {
    if (!OnlinePayReportActivity.k(this.ddj).isSelected())
      OnlinePayReportActivity.j(this.ddj).gn(-1); 
    OnlinePayReportActivity.j(this.ddj).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */