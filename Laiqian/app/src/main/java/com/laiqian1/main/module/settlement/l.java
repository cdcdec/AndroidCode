package com.laiqian.main.module.settlement;

import com.laiqian.main.b.c;
import com.laiqian.main.module.settlement.pay.b;
import io.reactivex.c.j;

class l extends Object implements j<b, c, Boolean, Boolean, Object> {
  l(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public Object a(b paramb, c paramc, Boolean paramBoolean1, Boolean paramBoolean2) throws Exception {
    if (!b.c(paramb))
      PosActivitySettlementDialogFragment.a(this.blV).a(paramb.OT()); 
    if (!c.f(paramc))
      (PosActivitySettlementDialogFragment.a(this.blV)).tvPaid.setText(paramc.aTd); 
    if (!paramBoolean2.booleanValue() && paramBoolean1.booleanValue() && !b.c(paramb)) {
      (PosActivitySettlementDialogFragment.a(this.blV)).submitButton.setText((paramb.OT()).aTc);
    } else if (!c.f(paramc)) {
      (PosActivitySettlementDialogFragment.a(this.blV)).submitButton.setText(paramc.aTc);
    } 
    return Boolean.valueOf(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */