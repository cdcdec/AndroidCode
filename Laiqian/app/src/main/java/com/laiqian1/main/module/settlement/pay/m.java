package com.laiqian.main.module.settlement.pay;

import android.util.Log;
import com.laiqian.entity.aq;
import com.laiqian.main.b.c;
import io.reactivex.c.h;

class m extends Object implements h<c, c> {
  m(PosActivitySettlementDialogPayTypeFragment paramPosActivitySettlementDialogPayTypeFragment) {}
  
  public c e(c paramc) throws Exception {
    Log.i("@emery payTypeFragment", "正常支付的点击事件");
    int i = paramc.aTv;
    if (i != 10001 && i != 10009 && i != 10014)
      switch (i) {
        default:
          return paramc;
        case 10006:
          if (aq.a((aq)this.boK.blQ.bmC.getValue()))
            PosActivitySettlementDialogPayTypeFragment.a(this.boK).show(); 
          break;
        case 10007:
          break;
      }  
    return paramc;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */