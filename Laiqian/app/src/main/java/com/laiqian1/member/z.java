package com.laiqian.member;

import android.view.View;
import com.laiqian.ui.a.w;

class z implements View.OnClickListener {
  z(MemberInfoActivity paramMemberInfoActivity) {}
  
  public void onClick(View paramView) {
    if (MemberInfoActivity.p(this.buu) == 1) {
      if (this.buu.btZ == null) {
        this.buu.btZ = new w(this.buu, MemberInfoActivity.a(this.buu).PZ(), new aa(this));
        this.buu.btZ.gn(0);
      } 
      this.buu.btZ.show();
      return;
    } 
    if (MemberInfoActivity.p(this.buu) == 2) {
      if (this.buu.bua == null) {
        this.buu.bua = new w(this.buu, MemberInfoActivity.a(this.buu).Qa(), new ab(this));
        this.buu.bua.gn(0);
      } 
      this.buu.bua.show();
      return;
    } 
    if (MemberInfoActivity.p(this.buu) == 3) {
      if (this.buu.bub == null) {
        if (this.buu.bum) {
          MemberInfoActivity.q(this.buu);
        } else {
          this.buu.bub = new w(this.buu, MemberInfoActivity.a(this.buu).Qb(), new ac(this));
        } 
        this.buu.bub.gn(0);
      } 
      this.buu.bub.show();
      return;
    } 
    if (MemberInfoActivity.p(this.buu) == 4 && this.buu.bum) {
      MemberInfoActivity.q(this.buu);
      this.buu.bub.show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */