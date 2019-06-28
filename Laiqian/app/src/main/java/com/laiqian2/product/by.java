package com.laiqian.product;

import com.laiqian.ui.a.r;
import com.laiqian.util.n;

class by implements r.a {
  by(bq parambq) {}
  
  public void xD() { bq.p(this.cQz).cancel(); }
  
  public void xE() {
    boolean bool = this.cQz.delete();
    bq.p(this.cQz).cancel();
    if (bool) {
      this.cQz.cancel();
      n.w(bq.q(this.cQz), 2131627489);
    } 
    if (bq.r(this.cQz) != null) {
      bq.a a1 = bq.r(this.cQz);
      String str1 = bq.s(this.cQz);
      String str2 = bq.t(this.cQz).getText().toString();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(bq.a(this.cQz));
      stringBuilder.append("");
      a1.b(bool, str1, str2, stringBuilder.toString(), bq.u(this.cQz));
    } 
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */