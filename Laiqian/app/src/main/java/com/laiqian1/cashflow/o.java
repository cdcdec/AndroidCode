package com.laiqian.cashflow;

import com.laiqian.cashflow.b.a;
import com.laiqian.ui.a.r;
import io.reactivex.g.a;

class o implements r.a {
  o(n paramn) {}
  
  public void xD() {}
  
  public void xE() {
    a a1 = new a(this.aJK.aJH);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(CashFlowDetailActivity.k(this.aJK.aJH));
    stringBuilder.append("");
    boolean bool = a1.bM(stringBuilder.toString());
    a1.close();
    if (bool) {
      a.aKh().r(new a.a(CashFlowDetailActivity.k(this.aJK.aJH), 3));
      this.aJK.aJH.setResult(-1);
    } 
    this.aJK.aJH.finish();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */