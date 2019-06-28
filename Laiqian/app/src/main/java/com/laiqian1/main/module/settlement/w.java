package com.laiqian.main.module.settlement;

import com.laiqian.entity.aq;
import io.reactivex.c.i;

class w extends Object implements i<aq, Boolean, Boolean, Boolean> {
  w(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public Boolean a(aq paramaq, Boolean paramBoolean1, Boolean paramBoolean2) throws Exception {
    boolean bool;
    if (paramaq.aSW != 0L && paramBoolean1.booleanValue() && paramBoolean2.booleanValue()) {
      bool = true;
    } else {
      bool = false;
    } 
    return Boolean.valueOf(bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */