package com.laiqian.takeaway.phone.setting;

import android.widget.CompoundButton;
import com.laiqian.d.a;

class p implements CompoundButton.OnCheckedChangeListener {
  p(PhoneOrderSettingFragment paramPhoneOrderSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramBoolean) {
      PhoneOrderSettingFragment.a(this.dvi);
      PhoneOrderSettingFragment.b(this.dvi).setEnabled(true);
      a.AZ().bY(true);
      PhoneOrderSettingFragment.c(this.dvi).setText(this.dvi.getString(2131630030));
      PhoneOrderSettingFragment.d(this.dvi).setVisibility(0);
      PhoneOrderSettingFragment.e(this.dvi).setBackgroundResource(2130772057);
      return;
    } 
    a.AZ().bY(false);
    PhoneOrderSettingFragment.c(this.dvi).setText(this.dvi.getString(2131630030));
    PhoneOrderSettingFragment.d(this.dvi).setVisibility(8);
    PhoneOrderSettingFragment.e(this.dvi).setBackgroundResource(2130772035);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */