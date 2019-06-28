package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.main.b.b;
import com.laiqian.main.module.settlement.pay.b;
import io.reactivex.c.c;
import java.util.List;

class bk extends Object implements c<Boolean, List<b>, b> {
  bk(ag.a parama, ag paramag) {}
  
  public b b(Boolean paramBoolean, List<b> paramList) throws Exception {
    Log.i(ag.Ou(), " 合并之后，第二种支付方式选中第一个");
    b b = b.boG;
    return (paramBoolean.booleanValue() && paramList.size() > 0) ? new b((b)paramList.get(0), false) : (b)this.bnJ.bns.getValue();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */