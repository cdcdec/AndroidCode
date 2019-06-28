package com.laiqian.main.module.settlement.pay;

import android.util.Log;
import com.laiqian.entity.v;
import com.laiqian.main.b.c;
import io.reactivex.c.j;
import java.util.List;

class r extends Object implements j<Boolean, List<c>, List<v>, v, c> {
  r(PosActivitySettlementDialogPayTypeFragment paramPosActivitySettlementDialogPayTypeFragment) {}
  
  public c a(Boolean paramBoolean, List<c> paramList1, List<v> paramList2, v paramv) throws Exception {
    c c;
    Log.i("@emery payTypeFragment", "初始化其他支付");
    if (paramBoolean.booleanValue() && paramList2.size() > 0) {
      c = (c)paramList1.get(paramList1.size() - 1);
    } else {
      c = c.bpu;
    } 
    if (c.view != null)
      PosActivitySettlementDialogPayTypeFragment.a(this.boK, c, paramList2, paramv); 
    return c;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */