package com.laiqian.member.report;

import java.util.HashMap;

class ai implements Runnable {
  ai(VipReportActivity paramVipReportActivity, HashMap paramHashMap) {}
  
  public void run() {
    if (this.bzK != null) {
      VipReportActivity.q(this.bzE).setText((CharSequence)this.bzK.get("totalGiftPoint"));
      String str = ((String)this.bzK.get("totalConsumePoint")).replace("-", "");
      VipReportActivity.o(this.bzE).setText((CharSequence)this.bzK.get("fTotalPoint"));
      VipReportActivity.o(this.bzE).setText(str);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */