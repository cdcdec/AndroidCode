package com.laiqian.member;

import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.ui.a.aj;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class ai implements aj.a {
  ai(MemberInfoActivity paramMemberInfoActivity) {}
  
  public void l(long paramLong1, long paramLong2) {
    if (c.bp(this.buu).getPrinters().isEmpty()) {
      n.w(this.buu, R.string.pos_print_unconnected);
      return;
    } 
    MemberInfoActivity.f(this.buu).dismiss();
    MemberInfoActivity.a(this.buu).m(paramLong1, paramLong2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */