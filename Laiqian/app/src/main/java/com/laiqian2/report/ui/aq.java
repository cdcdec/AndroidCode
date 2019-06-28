package com.laiqian.report.ui;

import android.view.View;

class aq implements View.OnClickListener {
  aq(ProductReport paramProductReport) {}
  
  public void onClick(View paramView) {
    for (byte b = 0; b < ProductReport.a(this.dfL).length; b++) {
      boolean bool;
      View view = ProductReport.a(this.dfL)[b];
      if (ProductReport.a(this.dfL)[b] == paramView) {
        bool = true;
      } else {
        bool = false;
      } 
      view.setSelected(bool);
    } 
    this.dfL.dfV.nm((String)paramView.getTag());
    this.dfL.AJ();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */