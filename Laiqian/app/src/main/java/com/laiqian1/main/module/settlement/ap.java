package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.util.n;
import io.reactivex.c.j;

class ap extends Object implements j<Double, Double, Boolean, Boolean, Double> {
  ap(ag paramag) {}
  
  public Double a(Double paramDouble1, Double paramDouble2, Boolean paramBoolean1, Boolean paramBoolean2) throws Exception {
    String str = ag.Ou();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("根据可抵扣的金额算出抵扣后金额 afterDiscountAmount=");
    stringBuilder.append(paramDouble2);
    stringBuilder.append("-couldDeductePointsAmount=");
    stringBuilder.append(paramDouble1);
    Log.i(str, stringBuilder.toString());
    double d2 = n.e(new Object[] { paramDouble2, paramDouble1 });
    double d1 = d2;
    if (d2 < 0.0D)
      d1 = 0.0D; 
    return Double.valueOf(d1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */