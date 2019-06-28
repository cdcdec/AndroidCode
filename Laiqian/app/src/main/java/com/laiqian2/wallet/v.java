package com.laiqian.wallet;

class v extends Thread {
  v(Withdrawals paramWithdrawals) {}
  
  public void run() {
    Withdrawals.b(this.dLH, getName());
    String str = k.N(Withdrawals.a(this.dLH).Ea(), Withdrawals.c(this.dLH).getText().toString().trim(), Withdrawals.b(this.dLH).getText().toString().trim());
    if (getName() == Withdrawals.k(this.dLH)) {
      if (this.dLH.isFinishing())
        return; 
      if (str == null) {
        Withdrawals.h(this.dLH).obtainMessage(1).sendToTarget();
        return;
      } 
      Withdrawals.h(this.dLH).obtainMessage(-1, str).sendToTarget();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */