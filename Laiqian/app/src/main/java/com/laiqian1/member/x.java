package com.laiqian.member;

import android.view.View;
import com.laiqian.ui.a.w;

class x implements View.OnClickListener {
  x(MemberInfoActivity paramMemberInfoActivity) {}
  
  public void onClick(View paramView) {
    if (this.buu.btY == null) {
      this.buu.btY = new w(this.buu, MemberInfoActivity.a(this.buu).PU(), new y(this));
      this.buu.btY.gn(0);
    } 
    if (this.buu.btZ != null && MemberInfoActivity.p(this.buu) == 1) {
      this.buu.btZ.gn(0);
    } else if (this.buu.bua != null && MemberInfoActivity.p(this.buu) == 2) {
      this.buu.bua.gn(0);
    } 
    this.buu.btY.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */