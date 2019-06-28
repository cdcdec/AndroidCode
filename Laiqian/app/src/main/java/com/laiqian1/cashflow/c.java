package com.laiqian.cashflow;

import com.laiqian.cashflow.a.c;
import com.laiqian.cashflow.a.e;
import com.laiqian.ui.a.aq;

class c extends Object implements aq.a<e> {
  c(b paramb) {}
  
  public void a(aq paramaq, int paramInt, e parame) {
    a.a(this.aJB.aJA, parame.getID());
    a.c(this.aJB.aJA).setText(parame.getName());
    a a1 = this.aJB.aJA;
    a a2 = this.aJB.aJA;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a.d(this.aJB.aJA));
    stringBuilder.append("");
    a.a(a1, a.a(a2, stringBuilder.toString()));
    if (a.e(this.aJB.aJA).size() > 0) {
      a.b(this.aJB.aJA, ((c)a.e(this.aJB.aJA).get(0)).getID());
      a.f(this.aJB.aJA).setText(((c)a.e(this.aJB.aJA).get(0)).getName());
      return;
    } 
    a.b(this.aJB.aJA, 0L);
    a.f(this.aJB.aJA).setText("");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */