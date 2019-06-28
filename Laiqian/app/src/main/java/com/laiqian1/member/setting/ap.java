package com.laiqian.member.setting;

import android.view.View;

class ap implements View.OnClickListener {
  ap(VipModeSettingActivity paramVipModeSettingActivity) {}
  
  public void onClick(View paramView) {
    if (this.bCH.Az())
      this.bCH.save(); 
    this.bCH.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */