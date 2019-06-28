package com.laiqian.member.report;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class ae implements w.a {
  ae(ab paramab) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    this.bzJ.bzE.bub.gn(paramInt);
    if (paramInt == 0) {
      VipReportActivity.j(this.bzJ.bzE).PY();
      VipReportActivity.j(this.bzJ.bzE).h(new String[] { "370010" });
    } else {
      VipReportActivity.j(this.bzJ.bzE).cY(false);
      VipReportActivity.j(this.bzJ.bzE).h(new String[] { "370010" });
      VipReportActivity.j(this.bzJ.bzE).fp(paramInt - 1);
    } 
    VipReportActivity.b(this.bzJ.bzE).setText(VipReportActivity.j(this.bzJ.bzE).fn(paramInt));
    VipReportActivity.e(this.bzJ.bzE);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */