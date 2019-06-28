package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import io.reactivex.c.c;

class ar extends Object implements c<aq, Double, Boolean> {
  ar(ag paramag) {}
  
  public Boolean a(aq paramaq, Double paramDouble) throws Exception {
    Log.i(ag.Ou(), " 会员赊账超过限制");
    if (!aq.a(paramaq) && a.AZ().Bu()) {
      double d = a.AZ().Bv();
      if (d >= 0.0D && paramDouble.doubleValue() - paramaq.aWo > d)
        return Boolean.valueOf(true); 
    } 
    return Boolean.valueOf(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */