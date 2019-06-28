package com.laiqian.print.dualscreen;

import android.view.View;

class h implements View.OnClickListener {
  h(DualScreenSettingsActivity paramDualScreenSettingsActivity) {}
  
  public void onClick(View paramView) {
    if (DualScreenSettingsActivity.b(this.cFt)) {
      DualScreenSettingsActivity.a(this.cFt, 100);
      return;
    } 
    DualScreenSettingsActivity.c(this.cFt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\dualscreen\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */