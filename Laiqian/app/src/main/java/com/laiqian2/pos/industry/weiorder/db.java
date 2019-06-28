package com.laiqian.pos.industry.weiorder;

import android.widget.CompoundButton;

class db implements CompoundButton.OnCheckedChangeListener {
  db(WeiOrderSettingFragment paramWeiOrderSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramBoolean) {
      this.cuP.cuL.cub = true;
      return;
    } 
    this.cuP.cuL.cub = false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */