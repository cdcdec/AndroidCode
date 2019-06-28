package com.laiqian.main;

import com.laiqian.basic.RootApplication;
import com.laiqian.main.b.c;

class br implements c.a {
  br(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void a(c paramc) {
    PosActivitySettlementDialog.access$1702(this.bcy, paramc);
    if (!PosActivitySettlementDialog.access$800(this.bcy)) {
      PosActivitySettlementDialog.access$1600(this.bcy).setTag(null);
      PosActivitySettlementDialog.access$1600(this.bcy).setText(paramc.aTc);
      if ((PosActivitySettlementDialog.access$1700(this.bcy)).aTv == 10009 && RootApplication.getLaiqianPreferenceManager().awk()) {
        PosActivitySettlementDialog.access$1600(this.bcy).setText(this.bcy.getContext().getString(2131629954));
        PosActivitySettlementDialog.access$1600(this.bcy).setTag("onlinePay");
      } 
      if ((PosActivitySettlementDialog.access$1700(this.bcy)).aTv == 10007 && RootApplication.getLaiqianPreferenceManager().awj()) {
        PosActivitySettlementDialog.access$1600(this.bcy).setText(this.bcy.getContext().getString(2131629954));
        PosActivitySettlementDialog.access$1600(this.bcy).setTag("onlinePay");
      } 
    } 
    PosActivitySettlementDialog.access$3100(this.bcy).setText(paramc.aTd);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */