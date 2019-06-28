package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.util.n;
import io.reactivex.c.j;

class al extends Object implements j<Double, Double, Double, Boolean, String> {
  al(ag paramag) {}
  
  public String a(Double paramDouble1, Double paramDouble2, Double paramDouble3, Boolean paramBoolean) throws Exception {
    Log.i(ag.Ou(), "应收变化后通知折扣 327");
    double d2 = (paramDouble1.doubleValue() - paramDouble3.doubleValue()) / (paramDouble2.doubleValue() - paramDouble3.doubleValue()) * 100.0D;
    if (Double.isNaN(d2))
      return String.valueOf(100); 
    double d1 = d2;
    if (paramBoolean.booleanValue())
      d1 = 100.0D - d2; 
    return n.e(Double.valueOf(d1));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */