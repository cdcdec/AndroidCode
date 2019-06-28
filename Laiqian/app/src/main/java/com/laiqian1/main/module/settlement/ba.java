package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.d.a;
import io.reactivex.c.h;

class ba extends Object implements h<Boolean, Boolean> {
  ba(ag paramag) {}
  
  public Boolean k(Boolean paramBoolean) throws Exception {
    boolean bool;
    Log.i(ag.Ou(), "apply mPayTypeFragmentVM.mSettlementVM.isMultipleShop.map");
    if (!a.AZ().Bu() && !paramBoolean.booleanValue()) {
      bool = true;
    } else {
      bool = false;
    } 
    return Boolean.valueOf(bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */