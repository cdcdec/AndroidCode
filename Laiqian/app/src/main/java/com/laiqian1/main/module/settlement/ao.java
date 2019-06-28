package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.entity.aq;
import com.laiqian.member.setting.bc;
import com.laiqian.util.n;
import io.reactivex.c.i;

class ao extends Object implements i<Double, Boolean, aq, Double> {
  ao(ag paramag) {}
  
  public Double a(Double paramDouble, Boolean paramBoolean, aq paramaq) throws Exception {
    String str = ag.Ou();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("积分抵扣开启后计算可以抵扣的金额 vip.point=");
    stringBuilder.append(paramaq.aWp);
    Log.i(str, stringBuilder.toString());
    if (paramBoolean.booleanValue()) {
      double d = Double.parseDouble(n.pj(bc.RH().an(paramaq.aWp)));
      return (paramDouble.doubleValue() < d) ? paramDouble : Double.valueOf(d);
    } 
    return Double.valueOf(0.0D);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */