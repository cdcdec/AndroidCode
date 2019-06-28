package com.laiqian.member;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class ab implements w.a {
  ab(z paramz) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    this.buz.buu.bua.gn(paramInt);
    if (paramInt == 0) {
      MemberInfoActivity.a(this.buz.buu).PY();
      MemberInfoActivity.a(this.buz.buu).h(new String[] { "370004", "370007", "370010" });
    } else if (paramInt == 1) {
      MemberInfoActivity.a(this.buz.buu).PY();
      MemberInfoActivity.a(this.buz.buu).h(new String[] { "370007" });
    } else if (paramInt == 2) {
      MemberInfoActivity.a(this.buz.buu).PY();
      MemberInfoActivity.a(this.buz.buu).h(new String[] { "370010" });
    } else {
      MemberInfoActivity.a(this.buz.buu).h(new String[] { "370004", "370007", "370010" });
      MemberInfoActivity.a(this.buz.buu).cY(false);
      MemberInfoActivity.a(this.buz.buu).fo(paramInt - 3);
    } 
    MemberInfoActivity.l(this.buz.buu).setText(MemberInfoActivity.a(this.buz.buu).fm(paramInt));
    MemberInfoActivity.o(this.buz.buu);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */