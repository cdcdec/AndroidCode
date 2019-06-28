package com.laiqian.member;

import android.view.View;
import com.laiqian.entity.g;
import com.laiqian.ui.a.w;

class j implements View.OnClickListener {
  j(MemberChangeActivity paramMemberChangeActivity) {}
  
  public void onClick(View paramView) {
    if (MemberChangeActivity.b(this.btq) == null) {
      MemberChangeActivity.a(this.btq, new w(this.btq, MemberChangeActivity.c(this.btq), new k(this)));
      if (MemberChangeActivity.g(this.btq).equals(((g)MemberChangeActivity.f(this.btq).get(0)).EV())) {
        MemberChangeActivity.b(this.btq).gn(0);
      } else if (MemberChangeActivity.g(this.btq).equals(((g)MemberChangeActivity.f(this.btq).get(1)).EV())) {
        MemberChangeActivity.b(this.btq).gn(1);
      } else if (MemberChangeActivity.g(this.btq).equals(((g)MemberChangeActivity.f(this.btq).get(2)).EV())) {
        MemberChangeActivity.b(this.btq).gn(2);
      } 
    } 
    MemberChangeActivity.b(this.btq).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */