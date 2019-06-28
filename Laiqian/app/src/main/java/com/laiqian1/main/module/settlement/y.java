package com.laiqian.main.module.settlement;

import com.laiqian.entity.aq;
import io.reactivex.c.g;

class y extends Object implements g<Object> {
  y(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public void accept(Object paramObject) throws Exception {
    (PosActivitySettlementDialogFragment.b(this.blV)).bmC.accept(aq.aWG);
    (PosActivitySettlementDialogFragment.a(this.blV)).bmm.setChecked(false);
    (PosActivitySettlementDialogFragment.b(this.blV)).bmF.accept(Boolean.valueOf(false));
    PosActivitySettlementDialogFragment.a(this.blV).hideVipRechargeButton();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */