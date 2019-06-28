package com.laiqian.member.setting.sms;

import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class n implements CompoundButton.OnCheckedChangeListener {
  n(SmsSettingFragment paramSmsSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    byte b;
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.o(this.bGR.getString(R.string.vip_setting_can_not_edit));
      if (this.bGR.bGP.bHa.bGN != paramBoolean)
        ((CheckBox)this.bGR.bGO.bGS.dwV.getView()).setChecked(this.bGR.bGP.bHa.bGN); 
      return;
    } 
    this.bGR.bGP.ec(paramBoolean);
    ViewGroup viewGroup = this.bGR.bGO.bGY;
    if (paramBoolean == true) {
      b = 0;
    } else {
      b = 8;
    } 
    viewGroup.setVisibility(b);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */