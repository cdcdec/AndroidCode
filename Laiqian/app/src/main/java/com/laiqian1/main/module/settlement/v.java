package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.main.b.b;
import com.laiqian.main.module.settlement.pay.b;
import com.laiqian.ui.a.aq;

class v extends Object implements aq.a<b> {
  v(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public void a(aq paramaq, int paramInt, b paramb) {
    Log.i("@emery dialogFragment", "showAfterSecondPayTypeClicked  ");
    b b1 = new b(paramb, true);
    (PosActivitySettlementDialogFragment.b(this.blV)).bmT.bns.accept(b1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */