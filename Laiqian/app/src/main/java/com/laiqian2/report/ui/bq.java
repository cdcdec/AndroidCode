package com.laiqian.report.ui;

import android.view.View;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.util.n;
import io.reactivex.g.a;

class bq implements View.OnClickListener {
  bq(ReportRoot paramReportRoot) {}
  
  public void onClick(View paramView) {
    if (a.bo(this.dgN).getPrinters().isEmpty()) {
      n.w(this.dgN, 2131627438);
      return;
    } 
    this.dgN.dgi.setVisibility(4);
    this.dgN.dgj.setVisibility(0);
    a.aKh().r(new br(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */