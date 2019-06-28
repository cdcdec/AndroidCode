package com.laiqian.report.ui;

import android.view.View;

class ao implements View.OnClickListener {
  ao(ProductReport paramProductReport) {}
  
  public void onClick(View paramView) {
    View[] arrayOfView = (View[])paramView.getTag();
    if (arrayOfView[1].isSelected()) {
      ProductReport.a(this.dfL, arrayOfView[0]);
      return;
    } 
    ProductReport.b(this.dfL, arrayOfView[1]);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */