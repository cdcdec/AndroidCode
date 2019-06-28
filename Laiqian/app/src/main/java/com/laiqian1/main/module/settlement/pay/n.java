package com.laiqian.main.module.settlement.pay;

import android.util.Log;
import com.laiqian.entity.aq;
import com.laiqian.entity.v;
import com.laiqian.main.b.c;
import io.reactivex.c.j;
import java.util.List;

class n extends Object implements j<c, List<c>, List<v>, aq, c> {
  c boL = c.bpu;
  
  n(PosActivitySettlementDialogPayTypeFragment paramPosActivitySettlementDialogPayTypeFragment) {}
  
  public c a(c paramc, List<c> paramList1, List<v> paramList2, aq paramaq) throws Exception {
    Log.i("@emery payTypeFragment", "根据选中的支付方式选中该方式");
    for (c c1 : paramList1) {
      if (paramc.aTv == 10006 && aq.a(paramaq)) {
        c1.a(10001, paramList2, new o(this));
        continue;
      } 
      c1.a(paramc.aTv, paramList2, new p(this));
    } 
    return this.boL;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */