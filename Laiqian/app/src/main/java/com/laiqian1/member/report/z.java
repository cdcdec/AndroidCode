package com.laiqian.member.report;

import android.view.View;
import com.laiqian.ui.a.w;

class z implements View.OnClickListener {
  z(VipReportActivity paramVipReportActivity) {}
  
  public void onClick(View paramView) {
    if (this.bzE.btY == null) {
      this.bzE.btY = new w(this.bzE, VipReportActivity.h(this.bzE), new aa(this));
      this.bzE.btY.gn(0);
    } 
    if (this.bzE.btZ != null)
      this.bzE.btZ.gn(0); 
    this.bzE.btY.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */