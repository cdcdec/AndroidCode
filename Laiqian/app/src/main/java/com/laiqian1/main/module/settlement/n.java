package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.auth.au;
import com.laiqian.entity.aq;
import io.reactivex.c.i;

class n extends Object implements i<aq, Boolean, au, Object> {
  n(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public Object a(aq paramaq, Boolean paramBoolean, au paramau) throws Exception {
    Log.i("@emery dialogFragment", "初始化会员");
    if (!aq.a(paramaq))
      this.blV.a(paramaq, paramBoolean.booleanValue(), paramau); 
    return Boolean.valueOf(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */