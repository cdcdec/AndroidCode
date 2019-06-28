package com.laiqian.member.setting.points;

import android.text.Editable;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.ui.r;

class d extends r {
  d(VipPointsSettingFragment paramVipPointsSettingFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (!TextUtils.isEmpty(paramEditable.toString()))
      try {
        double d1 = Double.parseDouble(paramEditable.toString());
        this.bFB.bFA.as(d1);
        return;
      } catch (Exception paramEditable) {
        a.e(paramEditable);
      }  
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\points\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */