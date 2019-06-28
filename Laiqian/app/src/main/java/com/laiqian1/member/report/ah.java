package com.laiqian.member.report;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class ah implements w.a {
  ah(VipReportActivity paramVipReportActivity) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    this.bzE.bub.gn(paramInt);
    VipReportActivity.j(this.bzE).PY();
    if (paramInt == 0) {
      VipReportActivity.j(this.bzE).h(VipReportActivity.j(this.bzE).Je());
      VipReportActivity.l(this.bzE);
    } else if (paramInt == 1) {
      VipReportActivity.j(this.bzE).dJ(" and nSpareField1>0 ");
      VipReportActivity.j(this.bzE).h(VipReportActivity.j(this.bzE).Je());
    } else if (paramInt == 2) {
      VipReportActivity.j(this.bzE).dJ(" and nSpareField1<0 ");
      VipReportActivity.j(this.bzE).h(VipReportActivity.j(this.bzE).Je());
    } 
    VipReportActivity.b(this.bzE).setText(VipReportActivity.j(this.bzE).fj(paramInt));
    VipReportActivity.m(this.bzE);
    VipReportActivity.n(this.bzE);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */