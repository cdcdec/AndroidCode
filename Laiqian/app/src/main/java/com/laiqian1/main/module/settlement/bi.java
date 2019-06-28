package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.main.b.c;
import com.laiqian.main.module.settlement.pay.b;
import io.reactivex.c.c;

class bi extends Object implements c<c, b, Boolean> {
  bi(ag.a parama, ag paramag) {}
  
  public Boolean a(c paramc, b paramb) throws Exception {
    Log.i(ag.Ou(), " 如果第一支付和第二支付一样应该合并,合并之后，第二种支付方式选中第一个");
    if (paramc.view != null && paramb.OT() != null && paramc.aTv == (paramb.OT()).aTv)
      if (paramc.aTv == 10013) {
        if (paramc.aTe == (paramb.OT()).aTx)
          return Boolean.valueOf(true); 
      } else {
        return Boolean.valueOf(true);
      }  
    return Boolean.valueOf(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */