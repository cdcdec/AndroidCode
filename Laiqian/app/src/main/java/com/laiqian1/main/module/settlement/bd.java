package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import io.reactivex.c.i;

class bd extends Object implements i<aq, Boolean, Boolean, Boolean> {
  bd(ag paramag) {}
  
  public Boolean a(aq paramaq, Boolean paramBoolean1, Boolean paramBoolean2) throws Exception {
    boolean bool;
    double d;
    Log.i(ag.Ou(), "是否需要设置会员折扣--");
    if (!aq.a(paramaq) && a.AZ().Bx()) {
      d = paramaq.discount;
    } else {
      d = a.AZ().Bn();
    } 
    if (d != a.AZ().Bn() && paramBoolean1.booleanValue() && !paramBoolean2.booleanValue()) {
      bool = true;
    } else {
      bool = false;
    } 
    return Boolean.valueOf(bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */