package com.laiqian.opentable;

import android.view.View;

class y implements View.OnClickListener {
  y(TableTimeCalculationActivity paramTableTimeCalculationActivity, View paramView) {}
  
  public void onClick(View paramView) {
    if (TableTimeCalculationActivity.c(this.bYr).isSelected())
      return; 
    this.bYs.setSelected(false);
    TableTimeCalculationActivity.c(this.bYr).setSelected(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */