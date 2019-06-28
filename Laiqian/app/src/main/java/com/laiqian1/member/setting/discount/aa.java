package com.laiqian.member.setting.discount;

import android.widget.CompoundButton;
import com.laiqian.d.a;

class aa implements CompoundButton.OnCheckedChangeListener {
  aa(VipSettingFragment paramVipSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    a.AZ().bN(paramBoolean);
    this.bDZ.bDK.dT(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */