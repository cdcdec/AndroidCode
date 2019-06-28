package com.laiqian.member;

import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class y implements w.a {
  y(x paramx) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    this.bux.buu.btY.gn(paramInt);
    MemberInfoActivity.a(this.bux.buu, paramInt);
    MemberInfoActivity.a(this.bux.buu).dJ("");
    switch (paramInt) {
      case 4:
        MemberInfoActivity.a(this.bux.buu).h(MemberInfoActivity.a(this.bux.buu).Je());
        MemberInfoActivity.k(this.bux.buu).setVisibility(0);
        MemberInfoActivity.a(this.bux.buu).PY();
        MemberInfoActivity.l(this.bux.buu).setText(MemberInfoActivity.a(this.bux.buu).fj(0));
        this.bux.buu.bum = true;
        MemberInfoActivity.a(this.bux.buu).dJ(" and nSpareField1!=0 ");
        MemberInfoActivity.m(this.bux.buu);
        break;
      case 3:
        if (RootApplication.getLaiqianPreferenceManager().QV() == 0 && a.zR().zZ()) {
          MemberInfoActivity.a(this.bux.buu).h(new String[] { "370011" });
          MemberInfoActivity.k(this.bux.buu).setVisibility(8);
          MemberInfoActivity.a(this.bux.buu).PY();
          break;
        } 
        MemberInfoActivity.a(this.bux.buu).h(MemberInfoActivity.a(this.bux.buu).Je());
        MemberInfoActivity.k(this.bux.buu).setVisibility(0);
        MemberInfoActivity.a(this.bux.buu).PY();
        MemberInfoActivity.l(this.bux.buu).setText(MemberInfoActivity.a(this.bux.buu).fj(0));
        this.bux.buu.bum = true;
        MemberInfoActivity.a(this.bux.buu).dJ(" and nSpareField1!=0 ");
        MemberInfoActivity.m(this.bux.buu);
        break;
      case 2:
        MemberInfoActivity.a(this.bux.buu).h(new String[] { "370004", "370007", "370010" });
        MemberInfoActivity.k(this.bux.buu).setVisibility(0);
        MemberInfoActivity.a(this.bux.buu).PY();
        MemberInfoActivity.l(this.bux.buu).setText(MemberInfoActivity.a(this.bux.buu).fm(0));
        break;
      case 1:
        MemberInfoActivity.a(this.bux.buu).h(new String[] { "370005" });
        MemberInfoActivity.k(this.bux.buu).setVisibility(0);
        MemberInfoActivity.a(this.bux.buu).PY();
        MemberInfoActivity.l(this.bux.buu).setText(MemberInfoActivity.a(this.bux.buu).fl(0));
        break;
      case 0:
        MemberInfoActivity.a(this.bux.buu).h(new String[] { "370004", "370007", "370005", "370010", "370011", "370009" });
        MemberInfoActivity.k(this.bux.buu).setVisibility(8);
        MemberInfoActivity.a(this.bux.buu).PY();
        break;
    } 
    MemberInfoActivity.n(this.bux.buu).setText(MemberInfoActivity.a(this.bux.buu).PU()[paramInt]);
    MemberInfoActivity.o(this.bux.buu);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */