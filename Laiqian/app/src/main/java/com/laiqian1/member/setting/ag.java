package com.laiqian.member.setting;

import android.widget.CompoundButton;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class ag implements CompoundButton.OnCheckedChangeListener {
  ag(VipLevelSettingFragment paramVipLevelSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.o(this.bCo.getString(R.string.vip_setting_can_not_edit));
      if (a.AZ().Bs() != paramBoolean)
        VipLevelSettingFragment.a.a(VipLevelSettingFragment.a(this.bCo)).setChecked(a.AZ().Bs()); 
      return;
    } 
    a.AZ().bM(paramBoolean);
    VipLevelSettingFragment.b(this.bCo);
    VipLevelSettingFragment.a(this.bCo).RC();
    this.bCo.bCk.dT(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */