package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.main.module.settlement.pay.b;
import io.reactivex.c.h;

class bo extends Object implements h<b, Boolean> {
  bo(ag.a.b paramb, ag.a parama) {}
  
  public Boolean a(b paramb) throws Exception {
    boolean bool;
    Log.i(ag.Ou(), "第二支付是否是在线支付mPaidSecondTypeItemSelectedWrapper.map(new Fu==792");
    if (paramb.OT() != null && ((paramb.OT()).bpq || ag.a.b.a(this.bnV, paramb.OT()))) {
      bool = true;
    } else {
      bool = false;
    } 
    return Boolean.valueOf(bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */