package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.util.n;
import io.reactivex.c.c;

class bc extends Object implements c<Double, Double, Boolean> {
  bc(ag paramag) {}
  
  public Boolean b(Double paramDouble1, Double paramDouble2) throws Exception {
    Log.i(ag.Ou(), "是否全部都是不能打折的商品 ");
    return Boolean.valueOf(n.bc(paramDouble1.doubleValue() - paramDouble2.doubleValue()));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */