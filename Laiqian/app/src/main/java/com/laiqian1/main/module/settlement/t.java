package com.laiqian.main.module.settlement;

import com.laiqian.auth.au;
import io.reactivex.c.g;

class t extends Object implements g<Double> {
  t(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public void g(Double paramDouble) throws Exception {
    au au;
    if (!(au = (au)(PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnC.bnN.getValue()).a(au) && au.aEs == 1 && au.aEt > paramDouble.doubleValue())
      PosActivitySettlementDialogFragment.a.b(PosActivitySettlementDialogFragment.a(this.blV), false); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */