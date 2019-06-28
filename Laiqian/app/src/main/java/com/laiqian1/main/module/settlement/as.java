package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.main.b.c;
import com.laiqian.util.n;
import io.reactivex.c.c;
import java.util.List;

class as extends Object implements c<c, Double, List<Integer>> {
  as(ag paramag) {}
  
  public List<Integer> a(c paramc, Double paramDouble) throws Exception {
    Log.i(ag.Ou(), "设置快捷金额 517 ");
    return (paramc.aTv == 10001) ? n.be(paramDouble.doubleValue()) : ag.a(this.bnl);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */