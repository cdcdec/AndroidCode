package com.laiqian.wallet;

class f extends Thread {
  f(e parame) {}
  
  public void run() {
    BindingAlipay.c(this.dLa.dKY, getName());
    super.run();
    String str1 = BindingAlipay.g(this.dLa.dKY).getText().toString().trim();
    String str2 = BindingAlipay.f(this.dLa.dKY).getText().toString().trim();
    String str3 = k.i(BindingAlipay.k(this.dLa.dKY).Tx(), str1, str2, BindingAlipay.l(this.dLa.dKY));
    if (getName() == BindingAlipay.m(this.dLa.dKY)) {
      if (this.dLa.dKY.isFinishing())
        return; 
      if (str3 == null) {
        BindingAlipay.k(this.dLa.dKY).bn(str1, str2);
        this.dLa.dKY.handler.sendEmptyMessage(2);
        return;
      } 
      this.dLa.dKY.handler.obtainMessage(-2, str3).sendToTarget();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */