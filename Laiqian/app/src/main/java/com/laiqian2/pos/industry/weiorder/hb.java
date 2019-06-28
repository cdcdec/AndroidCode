package com.laiqian.pos.industry.weiorder;

import com.laiqian.ui.a.r;
import com.orhanobut.logger.d;

class hb implements r.a {
  hb(WeshopSettingsActivity paramWeshopSettingsActivity, g paramg, int paramInt) {}
  
  public void xD() {
    if (this.bCd > 0) {
      WeshopSettingsActivity.access$300(this.cxk, this.bCd, false);
      return;
    } 
    if (this.bCd == -1) {
      this.cxk.finish();
      return;
    } 
    d.c("wrong argument %d", new Object[] { Integer.valueOf(this.bCd) });
  }
  
  public void xE() { this.cjx.save(); }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */