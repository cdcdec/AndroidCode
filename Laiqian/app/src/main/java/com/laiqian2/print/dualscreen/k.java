package com.laiqian.print.dualscreen;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class k implements w.a {
  k(DualScreenSettingsActivity paramDualScreenSettingsActivity) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        DualScreenSettingsActivity.f(this.cFt);
        return;
      case 0:
        break;
    } 
    DualScreenSettingsActivity.a(this.cFt, DualScreenSettingsActivity.e(this.cFt));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\dualscreen\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */