package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.entity.aq;
import io.reactivex.c.g;

class ab extends Object implements g<Boolean> {
  ab(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public void a(Boolean paramBoolean) throws Exception {
    Log.i("@emery dialogFragment", "apply 选中会员支付后的变化 272");
    if (!aq.a((aq)(PosActivitySettlementDialogFragment.b(this.blV)).bmC.getValue())) {
      if (paramBoolean.booleanValue()) {
        PosActivitySettlementDialogFragment.c(this.blV);
        PosActivitySettlementDialogFragment.a.a(PosActivitySettlementDialogFragment.a(this.blV));
        return;
      } 
      if (((Boolean)(PosActivitySettlementDialogFragment.b(this.blV)).bmQ.getValue()).booleanValue()) {
        PosActivitySettlementDialogFragment.d(this.blV);
        return;
      } 
      PosActivitySettlementDialogFragment.a(this.blV).hideVipRechargeButton();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */