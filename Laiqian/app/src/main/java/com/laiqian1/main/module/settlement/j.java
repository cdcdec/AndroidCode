package com.laiqian.main.module.settlement;

import com.laiqian.main.b.c;
import com.laiqian.util.n;
import io.reactivex.c.g;

class j extends Object implements g<String> {
  j(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public void eJ(String paramString) throws Exception {
    c c = (c)(PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnm.getValue();
    if (Double.parseDouble(paramString) > ((Double)(PosActivitySettlementDialogFragment.b(this.blV)).beU.getValue()).doubleValue() && (c.aTv == 10007 || c.aTv == 10009 || c.aTv == 10006)) {
      if (c.f(c))
        return; 
      if (c.aTv == 10007)
        n.eP(2131629624); 
      if (c.aTv == 10009)
        n.eP(2131629631); 
      if (c.aTv == 10006) {
        n.eP(2131626374);
        return;
      } 
    } else {
      (PosActivitySettlementDialogFragment.a(this.blV)).bmh.setText(paramString);
      n.j((PosActivitySettlementDialogFragment.a(this.blV)).bmh);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */