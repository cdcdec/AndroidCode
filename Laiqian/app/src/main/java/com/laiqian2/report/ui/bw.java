package com.laiqian.report.ui;

import android.view.View;
import com.laiqian.util.bd;

class bw implements View.OnClickListener {
  bw(ReportRoot paramReportRoot, boolean paramBoolean) {}
  
  public void onClick(View paramView) {
    String str1;
    String str2 = ReportRoot.h(this.dgN).getText().toString().trim();
    if (this.bxW) {
      str1 = ReportRoot.f(this.dgN).getText().toString();
    } else {
      str1 = "";
    } 
    if (str2.length() == 0) {
      ReportRoot.d(this.dgN).setText(2131627848);
      return;
    } 
    if (!bd.bH(this.dgN)) {
      ReportRoot.d(this.dgN).setText(2131627849);
      return;
    } 
    ReportRoot.d(this.dgN).setText(null);
    this.dgN.bvO.show();
    ReportRoot reportRoot = this.dgN;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append(str1);
    (new ReportRoot.c(reportRoot, stringBuilder.toString(), null)).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */