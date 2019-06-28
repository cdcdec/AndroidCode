package com.laiqian.main.module.settlement.pay;

import android.util.Log;
import com.laiqian.main.b.b;
import com.laiqian.main.b.c;
import io.reactivex.c.c;
import java.util.List;

class q extends Object implements c<c, List<b>, b> {
  q(PosActivitySettlementDialogPayTypeFragment paramPosActivitySettlementDialogPayTypeFragment) {}
  
  public b a(c paramc, List<b> paramList) throws Exception {
    Log.i("@emery payTypeFragment", "根据选中的支付方式选中改变第二支付显示内容");
    return (paramc.aTv == 10001 || paramc.aTv == 10014) ? new b(null, false) : new b((b)paramList.get(0), false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */