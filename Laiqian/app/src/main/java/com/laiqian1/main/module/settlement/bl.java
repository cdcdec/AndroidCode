package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.main.b.c;
import io.reactivex.c.h;

class bl extends Object implements h<c, Boolean> {
  bl(ag.a parama, ag paramag) {}
  
  public Boolean d(c paramc) throws Exception {
    Log.i(ag.Ou(), " 是否是在线支付 ");
    return Boolean.valueOf(ag.a.a(this.bnJ, paramc.aTv));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */