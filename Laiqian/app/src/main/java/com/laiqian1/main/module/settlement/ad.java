package com.laiqian.main.module.settlement;

import android.view.View;
import com.laiqian.basic.RootApplication;

class ad implements View.OnFocusChangeListener {
  ad(PosActivitySettlementDialogFragment.a parama) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      if (paramView == this.bmw.etTableNumbers) {
        RootApplication.getLaiqianPreferenceManager().hu(true);
        return;
      } 
      RootApplication.getLaiqianPreferenceManager().hu(false);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */