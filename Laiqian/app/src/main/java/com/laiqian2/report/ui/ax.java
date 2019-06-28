package com.laiqian.report.ui;

import android.view.View;

class ax implements View.OnClickListener {
  ax(ReportRoot paramReportRoot) {}
  
  public void onClick(View paramView) {
    if (!paramView.isSelected())
      ReportRoot.i(this.dgN).dn(-1L); 
    ReportRoot.i(this.dgN).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */