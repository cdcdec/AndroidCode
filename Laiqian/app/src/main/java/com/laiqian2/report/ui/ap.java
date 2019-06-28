package com.laiqian.report.ui;

import android.view.View;

class ap implements View.OnClickListener {
  ap(ProductReport paramProductReport) {}
  
  public void onClick(View paramView) {
    paramView = (View)paramView.getTag();
    if (paramView.isClickable())
      ProductReport.c(this.dfL, paramView); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */