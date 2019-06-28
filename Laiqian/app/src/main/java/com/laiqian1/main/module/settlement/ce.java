package com.laiqian.main.module.settlement;

import com.laiqian.main.cs;

class ce implements cs.a {
  ce(PosActivitySettlementDialogSubmitOrderFragment paramPosActivitySettlementDialogSubmitOrderFragment) {}
  
  public void LD() {
    this.boa.blQ.bmK.accept(Double.valueOf(0.0D));
    (PosActivitySettlementDialogSubmitOrderFragment.a(this.boa)).submitButton.setText(2131627343);
  }
  
  public void Z(double paramDouble) {
    if (paramDouble > 1.0E-6D) {
      PosActivitySettlementDialogSubmitOrderFragment.a(this.boa, true);
      this.boa.blQ.bmK.accept(Double.valueOf(((Double)this.boa.blQ.bmK.getValue()).doubleValue() + paramDouble));
      (PosActivitySettlementDialogSubmitOrderFragment.a(this.boa)).verificationCheckButton.setVisibility(0);
      return;
    } 
    PosActivitySettlementDialogSubmitOrderFragment.a(this.boa, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */