package com.laiqian.member.setting;

import android.text.Editable;
import android.text.TextUtils;
import com.laiqian.ui.r;

class f extends r {
  f(CreateVipGradeAndGradeDetailActivity paramCreateVipGradeAndGradeDetailActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (!TextUtils.isEmpty(paramEditable.toString()))
      CreateVipGradeAndGradeDetailActivity.b(this.bBn).cW(paramEditable.toString()); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */