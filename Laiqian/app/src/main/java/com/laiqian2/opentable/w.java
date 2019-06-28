package com.laiqian.opentable;

import android.view.View;

class w implements View.OnClickListener {
  w(TableTimeCalculationActivity paramTableTimeCalculationActivity) {}
  
  public void onClick(View paramView) {
    if (TableTimeCalculationActivity.a(this.bYr))
      TableTimeCalculationActivity.b(this.bYr); 
    this.bYr.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */