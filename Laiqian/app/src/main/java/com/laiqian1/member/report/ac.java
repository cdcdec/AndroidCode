package com.laiqian.member.report;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class ac implements w.a {
  ac(ab paramab) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    this.bzJ.bzE.btZ.gn(paramInt);
    if (paramInt == 0) {
      VipReportActivity.j(this.bzJ.bzE).PY();
    } else if (paramInt == 1) {
      VipReportActivity.j(this.bzJ.bzE).PY();
      VipReportActivity.j(this.bzJ.bzE).cY(true);
    } else {
      VipReportActivity.j(this.bzJ.bzE).cY(false);
      VipReportActivity.j(this.bzJ.bzE).fk(paramInt - 2);
    } 
    VipReportActivity.b(this.bzJ.bzE).setText(VipReportActivity.j(this.bzJ.bzE).fl(paramInt));
    VipReportActivity.e(this.bzJ.bzE);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */