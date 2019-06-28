package com.laiqian.opentable;

import android.view.View;

class z implements View.OnClickListener {
  z(TableTimeCalculationActivity paramTableTimeCalculationActivity, View paramView) {}
  
  public void onClick(View paramView) {
    if (this.bYs.isSelected())
      return; 
    TableTimeCalculationActivity.c(this.bYr).setSelected(false);
    this.bYs.setSelected(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */