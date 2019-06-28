package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.entity.aq;
import io.reactivex.c.c;

class bp extends Object implements c<Boolean, aq, Boolean> {
  bp(ag.a.b paramb, ag.a parama) {}
  
  public Boolean b(Boolean paramBoolean, aq paramaq) throws Exception {
    boolean bool;
    Log.i(ag.Ou(), "连锁会员");
    if (paramBoolean.booleanValue() && !aq.a(paramaq)) {
      bool = true;
    } else {
      bool = false;
    } 
    return Boolean.valueOf(bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */