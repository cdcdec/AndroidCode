package com.laiqian.pos.features;

import com.laiqian.pos.industry.weiorder.g;
import com.laiqian.ui.a.r;
import com.orhanobut.logger.d;

class n implements r.a {
  n(ScanCodeOrderDishesActivity paramScanCodeOrderDishesActivity, g paramg, int paramInt) {}
  
  public void xD() {
    if (this.bCd > 0) {
      ScanCodeOrderDishesActivity.access$200(this.cjw, this.bCd, false);
      return;
    } 
    if (this.bCd == -1) {
      this.cjw.finish();
      return;
    } 
    d.c("wrong argument %d", new Object[] { Integer.valueOf(this.bCd) });
  }
  
  public void xE() { this.cjx.save(); }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */