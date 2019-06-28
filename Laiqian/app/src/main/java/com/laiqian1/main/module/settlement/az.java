package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import io.reactivex.c.h;

class az extends Object implements h<PendingFullOrderDetail.a, Boolean> {
  az(ag paramag) {}
  
  public Boolean b(PendingFullOrderDetail.a parama) throws Exception {
    boolean bool;
    Log.i(ag.Ou(), "apply phoneHeader");
    if (parama.aVN > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return Boolean.valueOf(bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */