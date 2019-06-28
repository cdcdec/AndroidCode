package com.laiqian.member.setting.points;

import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class f implements CompoundButton.OnCheckedChangeListener {
  f(VipPointsSettingFragment paramVipPointsSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(R.string.vip_setting_can_not_edit);
      if (this.bFB.bFA.bFL.SE() != paramBoolean)
        ((CheckBox)this.bFB.bFz.bFE.dwV.getView()).setChecked(this.bFB.bFA.bFL.SE()); 
      return;
    } 
    this.bFB.bFA.ea(paramBoolean);
    if (paramBoolean) {
      this.bFB.bFz.bFH.setVisibility(0);
      ((ViewGroup)this.bFB.bFz.bFD.getView()).setVisibility(0);
      return;
    } 
    if (((CheckBox)this.bFB.bFz.bFD.dwV.getView()).isChecked()) {
      ((CheckBox)this.bFB.bFz.bFD.dwV.getView()).performClick();
      this.bFB.bFz.bFH.performClick();
    } 
    ((ViewGroup)this.bFB.bFz.bFD.getView()).setVisibility(8);
    this.bFB.bFz.bFH.setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\points\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */