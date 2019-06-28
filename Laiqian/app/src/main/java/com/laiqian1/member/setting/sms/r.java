package com.laiqian.member.setting.sms;

import com.laiqian.basic.RootApplication;
import com.laiqian.ui.ImageCheckBox;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class r implements ImageCheckBox.a {
  r(SmsSettingFragment paramSmsSettingFragment) {}
  
  public void a(ImageCheckBox paramImageCheckBox, boolean paramBoolean) {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.o(this.bGR.getString(R.string.vip_setting_can_not_edit));
      if (this.bGR.bGP.bHa.bGM != paramBoolean)
        this.bGR.bGO.bGX.setChecked(this.bGR.bGP.bHa.bGM); 
      return;
    } 
    this.bGR.bGP.ef(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */