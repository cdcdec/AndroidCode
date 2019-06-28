package com.laiqian.product;

import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;

class cu implements r.a {
  cu(ck paramck) {}
  
  public void xD() { ck.p(this.cRl).cancel(); }
  
  public void xE() {
    boolean bool = this.cRl.delete();
    ck.o(this.cRl);
    ck.p(this.cRl).cancel();
    if (bool) {
      this.cRl.cancel();
      n.w(ck.q(this.cRl), R.string.pos_product_deleted);
    } 
    if (ck.r(this.cRl) != null)
      ck.r(this.cRl).c(bool, ck.s(this.cRl), ck.t(this.cRl).getText().toString(), ck.u(this.cRl)); 
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */