package com.laiqian.member;

import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class bd implements Runnable {
  bd(MemberListActivity paramMemberListActivity, String[] paramArrayOfString) {}
  
  public void run() {
    String str = String.format(this.bvu.getResources().getString(R.string.member_quantity_amount), new Object[] { Integer.valueOf(n.parseInt(this.bvH[0])), by.a(by.sd(this.bvH[1]), 9999, this.bvu) });
    MemberListActivity.a(this.bvu).setText(str);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */