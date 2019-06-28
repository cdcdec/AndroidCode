package com.laiqian.member;

import android.view.View;

class bc implements View.OnClickListener {
  bc(MemberListActivity paramMemberListActivity) {}
  
  public void onClick(View paramView) {
    MemberListActivity.g(this.bvu).Qr();
    MemberListActivity.m(this.bvu).dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */