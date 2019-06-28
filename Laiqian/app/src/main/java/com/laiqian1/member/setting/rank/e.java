package com.laiqian.member.setting.rank;

import android.view.View;

class e implements View.OnClickListener {
  e(MemberRankDetailActivity paramMemberRankDetailActivity) {}
  
  public void onClick(View paramView) {
    if (!this.bFR.isFinishing())
      MemberRankDetailActivity.a(this.bFR).save(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\rank\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */