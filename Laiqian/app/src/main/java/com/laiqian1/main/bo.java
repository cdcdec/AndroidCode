package com.laiqian.main;

import com.laiqian.util.n;

class bo implements cs.a {
  bo(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void LD() {}
  
  public void Z(double paramDouble) {
    if (paramDouble > 1.0E-6D) {
      if (n.pl(PosActivitySettlementDialog.access$2900(this.bcy).getText().toString()))
        PosActivitySettlementDialog.access$3000(this.bcy, true); 
      PosActivitySettlementDialog.access$2900(this.bcy).setText(n.ba(paramDouble));
      return;
    } 
    PosActivitySettlementDialog.access$3000(this.bcy, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */