package com.laiqian.takeaway.phone.setting;

import android.widget.RadioGroup;

class b implements RadioGroup.OnCheckedChangeListener {
  b(PhoneChangeActivity paramPhoneChangeActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {
    if (paramInt == PhoneChangeActivity.b(this.duO).getId()) {
      PhoneChangeActivity.a(this.duO, 0);
      return;
    } 
    if (paramInt == PhoneChangeActivity.c(this.duO).getId())
      PhoneChangeActivity.a(this.duO, 1); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */