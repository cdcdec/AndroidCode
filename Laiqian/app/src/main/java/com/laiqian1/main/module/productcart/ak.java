package com.laiqian.main.module.productcart;

import com.laiqian.main.module.hardware.weight.h;
import com.laiqian.util.n;

class ak implements h.a {
  ak(aa paramaa, Double paramDouble) {}
  
  public void ad(double paramDouble) {
    if (paramDouble <= 0.0D) {
      aa.d(this.bjW).setText(n.a(this.bjZ, false, false));
      return;
    } 
    aa.d(this.bjW).setText(n.a(String.valueOf(Math.ceil(this.bjZ.doubleValue() / paramDouble)), false, false));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */