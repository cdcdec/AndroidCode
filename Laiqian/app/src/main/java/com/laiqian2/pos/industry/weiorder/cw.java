package com.laiqian.pos.industry.weiorder;

import android.widget.CompoundButton;

class cw implements CompoundButton.OnCheckedChangeListener {
  cw(WeiOrderSettingFragment paramWeiOrderSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramBoolean) {
      this.cuP.cuL.ctH.setEnabled(true);
      this.cuP.cuL.cub = true;
      WeiOrderSettingFragment.a(this.cuP, this.cuP.cuL);
      return;
    } 
    this.cuP.cuL.ctH.setEnabled(false);
    this.cuP.cuL.cub = false;
    WeiOrderSettingFragment.a(this.cuP);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */