package com.laiqian.main.module.settlement;

import com.laiqian.entity.aq;
import com.laiqian.member.a.a;

class r implements a.b {
  r(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public void b(aq paramaq) {
    (PosActivitySettlementDialogFragment.b(this.blV)).bmC.accept(paramaq);
    if (!aq.a(paramaq) && paramaq.aWo >= ((Double)(PosActivitySettlementDialogFragment.b(this.blV)).beU.getValue()).doubleValue())
      (PosActivitySettlementDialogFragment.b(this.blV)).bmz.accept((PosActivitySettlementDialogFragment.b(this.blV)).beU.getValue()); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */