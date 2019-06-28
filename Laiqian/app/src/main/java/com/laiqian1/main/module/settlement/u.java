package com.laiqian.main.module.settlement;

import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aq;
import com.laiqian.main.b.c;
import com.laiqian.util.n;
import io.reactivex.c.g;

class u extends Object implements g<c> {
  u(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public void c(c paramc) throws Exception {
    if (!aq.a((aq)(PosActivitySettlementDialogFragment.b(this.blV)).bmC.getValue())) {
      boolean bool = ((Boolean)(PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnC.bnT.getValue()).booleanValue();
      PosActivitySettlementDialogFragment.a.c(PosActivitySettlementDialogFragment.a(this.blV), bool ^ true);
      if (!bool) {
        if (RootApplication.getLaiqianPreferenceManager().atH()) {
          (PosActivitySettlementDialogFragment.a(this.blV)).etTableNumbers.requestFocus();
          return;
        } 
        n.j((PosActivitySettlementDialogFragment.a(this.blV)).bmh);
        return;
      } 
    } else {
      PosActivitySettlementDialogFragment.a.c(PosActivitySettlementDialogFragment.a(this.blV), true);
      if (RootApplication.getLaiqianPreferenceManager().atH() && !this.blV.blS) {
        (PosActivitySettlementDialogFragment.a(this.blV)).etTableNumbers.requestFocus();
        this.blV.blS = true;
        return;
      } 
      n.j((PosActivitySettlementDialogFragment.a(this.blV)).bmh);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlemen\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */