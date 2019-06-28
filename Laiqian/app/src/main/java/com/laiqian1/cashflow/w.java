package com.laiqian.cashflow;

import com.laiqian.cashflow.a.e;
import com.laiqian.ui.a.aq;

class w extends Object implements aq.a<e> {
  w(CashFlowReport paramCashFlowReport) {}
  
  public void a(aq paramaq, int paramInt, e parame) {
    if (parame.AR() == 300002L) {
      CashFlowReport.e(this.aJQ).kS(1);
    } else if (parame.AR() == 300001L) {
      CashFlowReport.e(this.aJQ).kS(2);
    } else {
      CashFlowReport.e(this.aJQ).kS(0);
    } 
    CashFlowReport.e(this.aJQ).kR(0);
    this.aJQ.AJ();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */