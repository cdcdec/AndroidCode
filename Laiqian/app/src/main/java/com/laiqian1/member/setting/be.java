package com.laiqian.member.setting;

import android.view.View;

class be implements View.OnClickListener {
  be(VipSmsSettingActivity paramVipSmsSettingActivity) {}
  
  public void onClick(View paramView) {
    this.bCW.save();
    this.bCW.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */