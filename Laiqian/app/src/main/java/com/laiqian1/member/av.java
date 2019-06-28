package com.laiqian.member;

import android.view.View;
import com.laiqian.util.n;

class av implements View.OnClickListener {
  av(MemberListActivity paramMemberListActivity) {}
  
  public void onClick(View paramView) {
    if (this.bvu.aDP != null)
      this.bvu.aDP.stop(); 
    MemberListActivity.h(this.bvu).setVisibility(8);
    MemberListActivity.i(this.bvu).setVisibility(0);
    MemberListActivity.b(this.bvu).setText("");
    n.a(this.bvu, MemberListActivity.b(this.bvu));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */