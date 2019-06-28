package com.laiqian.report.onlinepay;

import android.view.View;

class c implements View.OnClickListener {
  c(OnlinePayReportActivity paramOnlinePayReportActivity) {}
  
  public void onClick(View paramView) {
    if (!paramView.isSelected())
      OnlinePayReportActivity.i(this.ddj).gn(-1); 
    OnlinePayReportActivity.i(this.ddj).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */