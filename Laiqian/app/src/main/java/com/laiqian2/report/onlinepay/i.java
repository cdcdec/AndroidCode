package com.laiqian.report.onlinepay;

import android.view.View;
import com.laiqian.ui.a.w;

class i implements View.OnClickListener {
  i(OnlinePayReportActivity paramOnlinePayReportActivity) {}
  
  public void onClick(View paramView) {
    if (this.ddj.dde == null) {
      this.ddj.dde = new w(this.ddj, OnlinePayReportActivity.d(this.ddj), new j(this));
      this.ddj.dde.gn(0);
    } 
    this.ddj.dde.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */