package com.laiqian.member;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class aa implements w.a {
  aa(z paramz) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    this.buz.buu.btZ.gn(paramInt);
    if (paramInt == 0) {
      MemberInfoActivity.a(this.buz.buu).PY();
    } else if (paramInt == 1) {
      MemberInfoActivity.a(this.buz.buu).PY();
      MemberInfoActivity.a(this.buz.buu).cY(true);
    } else {
      MemberInfoActivity.a(this.buz.buu).cY(false);
      MemberInfoActivity.a(this.buz.buu).fk(paramInt - 2);
    } 
    MemberInfoActivity.l(this.buz.buu).setText(MemberInfoActivity.a(this.buz.buu).fl(paramInt));
    MemberInfoActivity.o(this.buz.buu);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */