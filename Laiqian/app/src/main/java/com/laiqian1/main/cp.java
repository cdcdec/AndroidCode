package com.laiqian.main;

import com.laiqian.d.a;
import com.laiqian.main.module.hardware.weight.c;
import com.laiqian.pos.hardware.b;
import com.laiqian.util.n;

class cp implements Runnable {
  cp(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void run() {
    if (PosActivitySettlementDialog.access$1300(this.bcy) != null)
      b.ckg.c(Double.valueOf(n.u(PosActivitySettlementDialog.access$1400(this.bcy)))); 
    if (a.AZ().BE())
      c.MD().ag(Double.parseDouble(PosActivitySettlementDialog.access$1400(this.bcy))); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */