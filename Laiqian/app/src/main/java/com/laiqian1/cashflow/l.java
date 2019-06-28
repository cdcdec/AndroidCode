package com.laiqian.cashflow;

import com.laiqian.cashflow.a.c;
import com.laiqian.ui.a.aq;

class l extends Object implements aq.a<c> {
  l(k paramk) {}
  
  public void a(aq paramaq, int paramInt, c paramc) {
    if (CashFlowDetailActivity.h(this.aJJ.aJH) != paramc.getID()) {
      CashFlowDetailActivity.b(this.aJJ.aJH, paramc.getID());
      CashFlowDetailActivity.f(this.aJJ.aJH).setText(paramc.getName());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */