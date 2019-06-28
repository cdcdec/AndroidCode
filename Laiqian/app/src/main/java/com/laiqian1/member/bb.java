package com.laiqian.member;

import android.content.Intent;
import android.view.View;

class bb implements View.OnClickListener {
  bb(MemberListActivity paramMemberListActivity) {}
  
  public void onClick(View paramView) {
    this.bvu.startActivity(new Intent(this.bvu, com.laiqian.member.transfer.MemberImportActivity.class));
    MemberListActivity.m(this.bvu).dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */