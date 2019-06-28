package com.laiqian.pos.industry.weiorder;

import android.widget.CompoundButton;

class fa implements CompoundButton.OnCheckedChangeListener {
  fa(WeshopInfoFragment paramWeshopInfoFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (!paramBoolean) {
      this.cwf.cvS.fs(paramBoolean);
      return;
    } 
    this.cwf.cvS.fs(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */