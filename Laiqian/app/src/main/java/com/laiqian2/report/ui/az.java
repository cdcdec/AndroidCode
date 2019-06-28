package com.laiqian.report.ui;

import android.view.View;

class az implements View.OnClickListener {
  az(ReportRoot paramReportRoot) {}
  
  public void onClick(View paramView) {
    if (!ReportRoot.j(this.dgN).isSelected())
      ReportRoot.k(this.dgN).dn(-1L); 
    ReportRoot.k(this.dgN).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */