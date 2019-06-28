package com.laiqian.member;

import android.view.View;
import com.laiqian.util.n;

class bo implements View.OnClickListener {
  bo(MemberListActivity paramMemberListActivity) {}
  
  public void onClick(View paramView) {
    MemberListActivity.h(this.bvu).setVisibility(0);
    MemberListActivity.i(this.bvu).setVisibility(8);
    MemberListActivity.b(this.bvu).requestFocus();
    MemberListActivity.b(this.bvu).requestFocusFromTouch();
    n.b(this.bvu, MemberListActivity.b(this.bvu));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */