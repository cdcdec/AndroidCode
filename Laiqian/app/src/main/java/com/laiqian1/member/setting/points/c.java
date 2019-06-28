package com.laiqian.member.setting.points;

import android.text.Editable;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.ui.r;

class c extends r {
  c(VipPointsSettingFragment paramVipPointsSettingFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (!TextUtils.isEmpty(paramEditable.toString()))
      try {
        double d = Double.parseDouble(paramEditable.toString());
        this.bFB.bFA.ar(d);
        return;
      } catch (Exception paramEditable) {
        a.e(paramEditable);
      }  
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\points\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */