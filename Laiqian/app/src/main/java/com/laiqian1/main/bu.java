package com.laiqian.main;

import com.laiqian.entity.u;

class bu implements b.a {
  bu(bt parambt, b paramb) {}
  
  public void eK(int paramInt) {
    u u = (u)PosActivitySettlementDialog.access$3400(this.bcB.bcy).get(paramInt);
    long l = PosActivitySettlementDialog.access$3500(this.bcB.bcy);
    PosActivitySettlementDialog posActivitySettlementDialog = this.bcB.bcy;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(u.an(u.FK()));
    stringBuilder.append("");
    PosActivitySettlementDialog.access$3602(posActivitySettlementDialog, stringBuilder.toString());
    PosActivitySettlementDialog.access$3502(this.bcB.bcy, u.FL());
    PosActivitySettlementDialog.access$3700(this.bcB.bcy).setText(u.FM());
    this.bcA.dismiss();
    if (l != u.FL())
      PosActivitySettlementDialog.access$3800(this.bcB.bcy, false, true); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */