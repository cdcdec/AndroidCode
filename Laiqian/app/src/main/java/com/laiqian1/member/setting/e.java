package com.laiqian.member.setting;

import android.text.Editable;
import android.text.TextUtils;
import com.laiqian.ui.r;

class e extends r {
  e(CreateVipGradeAndGradeDetailActivity paramCreateVipGradeAndGradeDetailActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (!TextUtils.isEmpty(paramEditable.toString())) {
      int i = Integer.parseInt(paramEditable.toString());
      CreateVipGradeAndGradeDetailActivity.b(this.bBn).es(i - 1);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */