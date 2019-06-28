package com.laiqian.main.module.settlement;

import android.util.Log;
import com.laiqian.main.module.settlement.pay.b;
import io.reactivex.c.g;

class cj extends Object implements g<b> {
  cj(PosActivitySettlementDialogSubmitOrderFragment paramPosActivitySettlementDialogSubmitOrderFragment) {}
  
  public void b(b paramb) throws Exception {
    Double double = (Double)this.boa.blQ.bmT.bnt.getValue();
    cy cy = (cy)this.boa.blQ.bmT.bnC.bnU.getValue();
    if (paramb.OT() != null && PosActivitySettlementDialogSubmitOrderFragment.a(this.boa, (paramb.OT()).aTv) && !cy.OF() && !cy.OG() && paramb.OS()) {
      Log.i("emery orderFragment", "根据第二支付弹出扫码支付  477");
      PosActivitySettlementDialogSubmitOrderFragment.a(this.boa, double.toString(), paramb, ((Boolean)this.boa.blQ.bmB.getValue()).booleanValue(), this.boa.payTypeItemViewSelected);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */