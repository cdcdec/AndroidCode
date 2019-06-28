package com.laiqian.member;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class ad implements w.a {
  ad(MemberInfoActivity paramMemberInfoActivity) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    this.buu.bub.gn(paramInt);
    MemberInfoActivity.a(this.buu).PY();
    if (paramInt == 0) {
      MemberInfoActivity.a(this.buu).h(MemberInfoActivity.a(this.buu).Je());
      MemberInfoActivity.a(this.buu).dJ(" and nSpareField1!=0 ");
    } else if (paramInt == 1) {
      MemberInfoActivity.a(this.buu).dJ(" and nSpareField1>0 ");
      MemberInfoActivity.a(this.buu).h(MemberInfoActivity.a(this.buu).Je());
    } else if (paramInt == 2) {
      MemberInfoActivity.a(this.buu).dJ(" and nSpareField1<0 ");
      MemberInfoActivity.a(this.buu).h(MemberInfoActivity.a(this.buu).Je());
    } 
    MemberInfoActivity.l(this.buu).setText(MemberInfoActivity.a(this.buu).fj(paramInt));
    MemberInfoActivity.o(this.buu);
    MemberInfoActivity.m(this.buu);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */