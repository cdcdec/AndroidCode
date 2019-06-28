package com.laiqian.pos.hold;

import com.laiqian.d.a;
import com.laiqian.opentable.common.ag;
import com.laiqian.opentable.common.b;
import com.laiqian.print.util.e;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;

class q implements r.a {
  q(OpenTableSettingActivity paramOpenTableSettingActivity, boolean paramBoolean) {}
  
  public void xD() { this.coe.cod.dismiss(); }
  
  public void xE() {
    String str;
    this.coe.zL();
    a.AZ().dZ(OpenTableSettingActivity.c(this.coe));
    a.AZ().cc(true);
    a a1 = a.AZ();
    if (b.XC()) {
      str = bd.awo();
    } else {
      str = "";
    } 
    a1.ce(str);
    if (bd.bH(this.coe.getActivity())) {
      ag ag = new ag();
      ag.a(new r(this));
      ag.execute(new Void[0]);
      return;
    } 
    e.i(new s(this));
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */