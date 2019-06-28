package com.laiqian.member;

import android.view.View;
import com.laiqian.basic.RootApplication;

class bg implements View.OnClickListener {
  bg(MemberListActivity paramMemberListActivity) {}
  
  public void onClick(View paramView) {
    if (RootApplication.getLaiqianPreferenceManager().Wq()) {
      MemberListActivity.p(this.bvu);
      return;
    } 
    MemberListActivity.q(this.bvu);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */