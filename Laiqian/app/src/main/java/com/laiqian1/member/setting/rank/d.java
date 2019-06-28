package com.laiqian.member.setting.rank;

import android.text.Editable;
import com.laiqian.ui.r;

class d extends r {
  d(MemberRankDetailActivity paramMemberRankDetailActivity) {}
  
  public void afterTextChanged(Editable paramEditable) { MemberRankDetailActivity.a(this.bFR).gd(paramEditable.toString()); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\rank\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */