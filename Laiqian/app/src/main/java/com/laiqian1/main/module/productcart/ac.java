package com.laiqian.main.module.productcart;

import com.laiqian.d.a;
import com.laiqian.main.module.hardware.weight.h;
import com.laiqian.util.n;

class ac implements Runnable {
  ac(aa paramaa, Double paramDouble) {}
  
  public void run() {
    if (this.bjX.doubleValue() <= 0.0D) {
      n.eP(2131630521);
      return;
    } 
    if (a.AZ().Cs()) {
      h h = new h(aa.j(this.bjW));
      h.a(new ad(this));
      double d = h.MN();
      if (d < 0.0D) {
        h.cm(aa.a(this.bjW).getText().toString());
        return;
      } 
      aa.d(this.bjW).setText(n.a(String.valueOf(Math.ceil(this.bjX.doubleValue() / d)), false, false));
      return;
    } 
    aa.d(this.bjW).setText(n.a(this.bjX, false, false));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */