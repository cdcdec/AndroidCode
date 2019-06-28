package com.laiqian.member.setting.points;

import android.text.Editable;
import com.google.a.a.a.a.a.a;
import com.laiqian.ui.r;

class g extends r {
  g(VipPointsSettingFragment paramVipPointsSettingFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {
    try {
      int i = Integer.parseInt(paramEditable.toString());
      this.bFB.bFA.fV(i);
      return;
    } catch (Exception paramEditable) {
      a.e(paramEditable);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\points\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */