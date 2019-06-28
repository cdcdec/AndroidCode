package com.laiqian.main.module.settlement;

import com.laiqian.main.b.c;
import com.laiqian.main.module.settlement.pay.b;
import io.reactivex.c.g;

class bx extends Object implements g<c> {
  bx(PosActivitySettlementDialogSubmitOrderFragment paramPosActivitySettlementDialogSubmitOrderFragment) {}
  
  public void c(c paramc) throws Exception {
    this.boa.payTypeItemViewSelected = paramc;
    if (PosActivitySettlementDialogSubmitOrderFragment.a(this.boa, this.boa.payTypeItemViewSelected.aTv) && !((cy)this.boa.blQ.bmT.bnC.bnU.getValue()).OG() && !((cy)this.boa.blQ.bmT.bnC.bnU.getValue()).OF())
      PosActivitySettlementDialogSubmitOrderFragment.a(this.boa, ((Double)this.boa.blQ.bmz.getValue()).toString(), (b)this.boa.blQ.bmT.bnr.getValue(), ((Boolean)this.boa.blQ.bmB.getValue()).booleanValue(), this.boa.payTypeItemViewSelected); 
    if (this.boa.payTypeItemViewSelected.aTv != 10014) {
      (PosActivitySettlementDialogSubmitOrderFragment.a(this.boa)).verificationCheckButton.setVisibility(8);
      return;
    } 
    PosActivitySettlementDialogSubmitOrderFragment.b(this.boa);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */