package com.laiqian.member.setting.credit;

import android.view.ViewGroup;
import android.widget.CompoundButton;

class b implements CompoundButton.OnCheckedChangeListener {
  b(VipCreditSettingFragment paramVipCreditSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    byte b1;
    this.bDa.bCZ.dU(paramBoolean);
    if (paramBoolean)
      VipCreditSettingFragment.a(this.bDa); 
    ViewGroup viewGroup = (ViewGroup)this.bDa.bCY.bDb.getView();
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup.setVisibility(b1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\credit\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */