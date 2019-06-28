package com.laiqian.main.module.settlement.pay;

import android.util.Log;
import com.laiqian.entity.v;
import com.laiqian.main.b.c;
import io.reactivex.c.c;

class h extends Object implements c<c, v, c> {
  h(PosActivitySettlementDialogPayTypeFragment paramPosActivitySettlementDialogPayTypeFragment) {}
  
  public c a(c paramc, v paramv) throws Exception {
    Log.i("payTypeFragment", "apply 取其他支付为当前选中支付方式 518");
    return !v.a(paramv) ? paramc : c.bpu;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */