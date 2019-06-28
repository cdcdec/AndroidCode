package com.laiqian.member.report;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class ad implements w.a {
  ad(ab paramab) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    this.bzJ.bzE.bua.gn(paramInt);
    if (paramInt == 0) {
      VipReportActivity.j(this.bzJ.bzE).PY();
      VipReportActivity.j(this.bzJ.bzE).h(new String[] { "370004", "370007", "370010" });
    } else if (paramInt == 1) {
      VipReportActivity.j(this.bzJ.bzE).PY();
      VipReportActivity.j(this.bzJ.bzE).h(new String[] { "370007" });
    } else if (paramInt == 2) {
      VipReportActivity.j(this.bzJ.bzE).PY();
      VipReportActivity.j(this.bzJ.bzE).h(new String[] { "370010" });
    } else {
      VipReportActivity.j(this.bzJ.bzE).cY(false);
      VipReportActivity.j(this.bzJ.bzE).h(new String[] { "370004", "370007", "370010" });
      VipReportActivity.j(this.bzJ.bzE).fo(paramInt - 3);
    } 
    VipReportActivity.b(this.bzJ.bzE).setText(VipReportActivity.j(this.bzJ.bzE).fm(paramInt));
    VipReportActivity.e(this.bzJ.bzE);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */