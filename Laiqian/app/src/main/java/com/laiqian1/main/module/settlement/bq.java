package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.c.a;
import com.laiqian.entity.aq;
import com.laiqian.entity.c;
import io.reactivex.c.j;

class bq extends Object implements j<Boolean, Boolean, Boolean, c, Boolean> {
  bq(ag.a.b paramb, ag.a parama) {}
  
  public Boolean a(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, c paramc) throws Exception {
    boolean bool;
    Log.i(ag.Ou(), "断evako订单是否可以结算(选中支付方式后就会判断");
    if (a.zR().Ab() && paramBoolean1.booleanValue() && !paramBoolean2.booleanValue() && !paramBoolean3.booleanValue() && !aq.a(paramc)) {
      bool = true;
    } else {
      bool = false;
    } 
    return Boolean.valueOf(bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */