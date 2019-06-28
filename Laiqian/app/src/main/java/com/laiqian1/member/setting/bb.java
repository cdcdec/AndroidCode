package com.laiqian.member.setting;

import com.laiqian.pos.settings.aa;
import com.laiqian.ui.a.r;
import com.orhanobut.logger.d;

class bb implements r.a {
  bb(VipSettingsActivity paramVipSettingsActivity, aa paramaa, int paramInt) {}
  
  public void xD() {
    if (this.bCd > 0) {
      VipSettingsActivity.access$200(this.bCN, this.bCd, false);
      return;
    } 
    if (this.bCd == -1) {
      this.bCN.finish();
      return;
    } 
    d.c("wrong argument %d", new Object[] { Integer.valueOf(this.bCd) });
  }
  
  public void xE() { this.bCc.save(); }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */