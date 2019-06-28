package com.laiqian.wallet;

import com.google.a.a.a.a.a.a;

class b extends Thread {
  b(a parama) {}
  
  public void run() {
    BindingAlipay.a(this.dKZ.dKY, getName());
    super.run();
    try {
      BindingAlipay.b(this.dKZ.dKY, k.h(false, BindingAlipay.c(this.dKZ.dKY).getText().toString()));
      if (getName() == BindingAlipay.d(this.dKZ.dKY)) {
        if (this.dKZ.dKY.isFinishing())
          return; 
        this.dKZ.dKY.handler.sendEmptyMessage(1);
        return;
      } 
      return;
    } catch (h h) {
      a.e(h);
      this.dKZ.dKY.handler.obtainMessage(-1, h.getMessage()).sendToTarget();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */