package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import io.reactivex.c.j;

class aj extends Object implements j<Boolean, aq, Boolean, Boolean, Double> {
  aj(ag paramag) {}
  
  public Double a(Boolean paramBoolean1, aq paramaq, Boolean paramBoolean2, Boolean paramBoolean3) throws Exception {
    Log.i(ag.Ou(), "初始化折后 329");
    return (paramBoolean2.booleanValue() || !paramBoolean3.booleanValue()) ? Double.valueOf(100.0D) : ((paramBoolean1.booleanValue() && !aq.a(paramaq)) ? Double.valueOf(paramaq.discount) : Double.valueOf(a.AZ().Bn()));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */