package com.laiqian.main;

import com.laiqian.crash.model.CrashApplication;

class cd implements di.a {
  cd(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void KK() { PosActivitySettlementDialog.access$5602(this.bcy, null); }
  
  public void KL() { PosActivitySettlementDialog.access$5700(this.bcy); }
  
  public void KM() {
    this.bcy.toggleBarcodeProgress(8);
    this.bcy.setCanOperate(true);
  }
  
  public void a(bb parambb, boolean paramBoolean) {
    if (PosActivitySettlementDialog.access$5100(this.bcy))
      CrashApplication.getLaiqianPreferenceManager().hu(PosActivitySettlementDialog.access$5200(this.bcy)); 
    PosActivitySettlementDialog.access$5300(this.bcy);
    PosActivitySettlementDialog.access$1000(this.bcy).f(parambb, paramBoolean);
    this.bcy.cancel();
    PosActivitySettlementDialog.access$4902(this.bcy, null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */