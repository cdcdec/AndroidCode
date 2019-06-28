package com.laiqian.main.module.settlement.pay;

import android.util.Log;
import com.laiqian.entity.aq;
import io.reactivex.c.c;

class e extends Object implements c<aq, Boolean, Object> {
  e(PosActivitySettlementDialogPayTypeFragment paramPosActivitySettlementDialogPayTypeFragment) {}
  
  public Object a(aq paramaq, Boolean paramBoolean) throws Exception {
    Log.i("@emery payTypeFragment", "是否隐藏支付方式");
    if (aq.a(paramaq)) {
      if (paramBoolean.booleanValue())
        PosActivitySettlementDialogPayTypeFragment.c(this.boK).OW(); 
    } else if (paramBoolean.booleanValue()) {
      PosActivitySettlementDialogPayTypeFragment.c(this.boK).OX();
    } 
    return Boolean.valueOf(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */