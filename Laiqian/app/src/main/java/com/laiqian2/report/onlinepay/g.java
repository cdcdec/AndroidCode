package com.laiqian.report.onlinepay;

import android.view.View;
import com.laiqian.ui.a.w;

class g implements View.OnClickListener {
  g(OnlinePayReportActivity paramOnlinePayReportActivity) {}
  
  public void onClick(View paramView) {
    if (this.ddj.ddd == null) {
      this.ddj.ddd = new w(this.ddj, OnlinePayReportActivity.c(this.ddj), new h(this));
      this.ddj.ddd.gn(0);
    } 
    this.ddj.ddd.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */