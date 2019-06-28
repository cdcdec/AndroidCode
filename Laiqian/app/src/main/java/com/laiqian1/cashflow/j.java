package com.laiqian.cashflow;

import com.laiqian.cashflow.a.c;
import com.laiqian.cashflow.a.e;
import com.laiqian.ui.a.aq;

class j extends Object implements aq.a<e> {
  j(i parami) {}
  
  public void a(aq paramaq, int paramInt, e parame) {
    if (CashFlowDetailActivity.c(this.aJI.aJH) != parame.getID()) {
      CashFlowDetailActivity.a(this.aJI.aJH, parame.getID());
      CashFlowDetailActivity.d(this.aJI.aJH).setText(parame.getName());
      CashFlowDetailActivity cashFlowDetailActivity1 = this.aJI.aJH;
      CashFlowDetailActivity cashFlowDetailActivity2 = this.aJI.aJH;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(CashFlowDetailActivity.c(this.aJI.aJH));
      stringBuilder.append("");
      CashFlowDetailActivity.a(cashFlowDetailActivity1, CashFlowDetailActivity.a(cashFlowDetailActivity2, stringBuilder.toString()));
      if (CashFlowDetailActivity.e(this.aJI.aJH).size() > 0) {
        CashFlowDetailActivity.b(this.aJI.aJH, ((c)CashFlowDetailActivity.e(this.aJI.aJH).get(0)).getID());
        CashFlowDetailActivity.f(this.aJI.aJH).setText(((c)CashFlowDetailActivity.e(this.aJI.aJH).get(0)).getName());
        return;
      } 
      CashFlowDetailActivity.b(this.aJI.aJH, 0L);
      CashFlowDetailActivity.f(this.aJI.aJH).setText("");
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */