package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.util.n;
import io.reactivex.c.i;

class ak extends Object implements i<Double, Double, Double, Double> {
  ak(ag paramag) {}
  
  public Double a(Double paramDouble1, Double paramDouble2, Double paramDouble3) throws Exception {
    double d = (paramDouble1.doubleValue() - paramDouble3.doubleValue()) / 100.0D * paramDouble2.doubleValue() + paramDouble3.doubleValue();
    String str = ag.Ou();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("折扣变化后通知折后应收 357 afterDiscountAmount= ");
    stringBuilder.append(d);
    Log.i(str, stringBuilder.toString());
    return Double.valueOf(Double.parseDouble(n.e(Double.valueOf(d))));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */