package com.laiqian.main.module.settlement;

import android.util.Log;
import io.reactivex.c.j;

class m extends Object implements j<Double, Double, cy, Boolean, Object> {
  m(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public Object b(Double paramDouble1, Double paramDouble2, cy paramcy, Boolean paramBoolean) throws Exception {
    Log.i("@emery dialogFragment", "dialogFragment根据选中支付方式后能否开始结算更新UI");
    PosActivitySettlementDialogFragment.a(this.blV, paramDouble1, paramDouble2, paramcy, paramBoolean);
    return Boolean.valueOf(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */