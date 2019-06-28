package com.laiqian.member;

import com.laiqian.entity.g;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class k implements w.a {
  k(j paramj) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    MemberChangeActivity.b(this.bts.btq, paramInt);
    MemberChangeActivity.b(this.bts.btq).gn(paramInt);
    MemberChangeActivity.d(this.bts.btq).setText(MemberChangeActivity.c(this.bts.btq)[paramInt]);
    MemberChangeActivity.a(this.bts.btq, ((g)MemberChangeActivity.f(this.bts.btq).get(MemberChangeActivity.e(this.bts.btq))).getId());
    MemberChangeActivity.a(this.bts.btq, MemberChangeActivity.c(this.bts.btq)[paramInt]);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */