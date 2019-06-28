package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.main.b.c;
import io.reactivex.c.c;

class g extends Object implements c<c, Boolean, Object> {
  g(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public Object a(c paramc, Boolean paramBoolean) throws Exception {
    Log.i("@emery dialogFragment", "根据选中的支付方式处理DialogFragment应该的变化 353 ");
    PosActivitySettlementDialogFragment.a(this.blV, Integer.valueOf(paramc.aTv), paramBoolean.booleanValue());
    return Boolean.valueOf(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */