package com.laiqian.member.report;

import com.laiqian.member.d.a;
import com.laiqian.util.by;
import io.reactivex.c.g;
import java.util.List;
import java.util.Map;

class j extends Object implements g<List<Map<String, String>>> {
  j(i parami) {}
  
  public void r(List<Map<String, String>> paramList) throws Exception {
    this.bzF.bzE.bzr.u(paramList);
    this.bzF.bzE.bzr.e(this.bzF.bzE.bqs);
    this.bzF.bzE.bzr.userName = VipReportActivity.a(this.bzF.bzE).getText().toString().trim();
    String str1 = VipReportActivity.b(this.bzF.bzE).getText().toString().trim();
    String str2 = VipReportActivity.c(this.bzF.bzE).getText().toString().trim();
    if (!by.isNull(str1)) {
      a a = this.bzF.bzE.bzr;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append("-");
      stringBuilder.append(str1);
      a.bxT = stringBuilder.toString();
    } else {
      this.bzF.bzE.bzr.bxT = str2;
    } 
    this.bzF.bzE.bzr.QK();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */