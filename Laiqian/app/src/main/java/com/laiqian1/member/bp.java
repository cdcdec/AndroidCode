package com.laiqian.member;

import android.view.View;
import com.laiqian.c.a;

class bp implements View.OnClickListener {
  bp(MemberListActivity paramMemberListActivity) {}
  
  public void onClick(View paramView) {
    if (a.zR().An()) {
      MemberListActivity.g(this.bvu).Qr();
      return;
    } 
    MemberListActivity.a(this.bvu, paramView);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */