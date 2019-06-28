package com.laiqian.member.report;

import android.view.View;
import com.laiqian.ui.a.w;

class ab implements View.OnClickListener {
  ab(VipReportActivity paramVipReportActivity) {}
  
  public void onClick(View paramView) {
    if (VipReportActivity.i(this.bzE) == 1) {
      if (this.bzE.btZ == null) {
        this.bzE.btZ = new w(this.bzE, VipReportActivity.j(this.bzE).PZ(), new ac(this));
        this.bzE.btZ.gn(0);
      } 
      this.bzE.btZ.show();
      return;
    } 
    if (VipReportActivity.i(this.bzE) == 2) {
      if (this.bzE.bua == null) {
        this.bzE.bua = new w(this.bzE, VipReportActivity.j(this.bzE).Qa(), new ad(this));
        this.bzE.bua.gn(0);
      } 
      this.bzE.bua.show();
      return;
    } 
    if (VipReportActivity.i(this.bzE) == 3) {
      if (this.bzE.bub == null)
        if (this.bzE.bum) {
          VipReportActivity.k(this.bzE);
        } else {
          this.bzE.bub = new w(this.bzE, VipReportActivity.j(this.bzE).Qb(), new ae(this));
          this.bzE.bub.gn(0);
        }  
      this.bzE.bub.show();
      return;
    } 
    if (VipReportActivity.i(this.bzE) == 4) {
      if (this.bzE.bub == null)
        if (this.bzE.bum) {
          VipReportActivity.k(this.bzE);
          this.bzE.bub.gn(0);
          this.bzE.bub.show();
        } else {
          this.bzE.bub = new w(this.bzE, VipReportActivity.j(this.bzE).PW(), new af(this));
          this.bzE.bub.gn(0);
        }  
      this.bzE.bub.show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */