package com.laiqian.member.setting.points;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class e implements CompoundButton.OnCheckedChangeListener {
  e(VipPointsSettingFragment paramVipPointsSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(R.string.vip_setting_can_not_edit);
      if (this.bFB.bFA.bFL.SB() != paramBoolean)
        ((CheckBox)this.bFB.bFz.bFD.dwV.getView()).setChecked(this.bFB.bFA.bFL.SB()); 
      return;
    } 
    this.bFB.bFA.dZ(paramBoolean);
    this.bFB.C(Boolean.valueOf(paramBoolean));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\points\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */