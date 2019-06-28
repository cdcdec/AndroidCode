package com.laiqian.member;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.vip.R;

class o implements w.a {
  o(MemberChangeActivity paramMemberChangeActivity) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    MemberChangeActivity.c(this.btq, paramInt);
    this.btq.bsK.setText(MemberChangeActivity.h(this.btq)[MemberChangeActivity.i(this.btq)]);
    if (this.btq.getString(R.string.pos_member_card_in_use).equals(MemberChangeActivity.h(this.btq)[MemberChangeActivity.i(this.btq)])) {
      this.btq.bsI = "380001";
      return;
    } 
    if (this.btq.getString(R.string.pos_member_card_in_lock).equals(MemberChangeActivity.h(this.btq)[MemberChangeActivity.i(this.btq)]))
      this.btq.bsI = "380003"; 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */