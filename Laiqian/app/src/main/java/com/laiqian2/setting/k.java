package com.laiqian.setting;

import android.text.Editable;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.ui.r;

class k extends r {
  k(DiscountSettingActivity paramDiscountSettingActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (TextUtils.isEmpty(paramEditable))
      return; 
    try {
      double d;
      DiscountSettingActivity.a(this.djZ, Double.parseDouble(paramEditable.toString().trim()));
      DiscountSettingActivity discountSettingActivity;
      if ((discountSettingActivity = this.djZ).b(this.djZ)) {
        d = 100.0D - DiscountSettingActivity.c(this.djZ);
      } else {
        d = DiscountSettingActivity.c(this.djZ);
      } 
      DiscountSettingActivity.a(discountSettingActivity, d);
      return;
    } catch (NumberFormatException paramEditable) {
      a.e(paramEditable);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */