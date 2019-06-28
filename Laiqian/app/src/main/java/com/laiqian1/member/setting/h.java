package com.laiqian.member.setting;

import android.text.Editable;
import android.text.TextUtils;
import com.laiqian.ui.r;

class h extends r {
  h(CreateVipGradeAndGradeDetailActivity paramCreateVipGradeAndGradeDetailActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (!TextUtils.isEmpty(paramEditable.toString()))
      CreateVipGradeAndGradeDetailActivity.b(this.bBn).j(Double.parseDouble(paramEditable.toString())); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */