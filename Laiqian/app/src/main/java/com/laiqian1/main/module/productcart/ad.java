package com.laiqian.main.module.productcart;

import com.laiqian.main.module.hardware.weight.h;
import com.laiqian.util.n;

class ad implements h.a {
  ad(ac paramac) {}
  
  public void ad(double paramDouble) {
    if (paramDouble <= 0.0D) {
      aa.d(this.bjY.bjW).setText(n.a(this.bjY.bjX, false, false));
      return;
    } 
    aa.d(this.bjY.bjW).setText(n.a(String.valueOf(Math.ceil(this.bjY.bjX.doubleValue() / paramDouble)), false, false));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */