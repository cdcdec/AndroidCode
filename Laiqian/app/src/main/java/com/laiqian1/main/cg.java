package com.laiqian.main;

import android.view.View;
import com.laiqian.main.b.c;
import com.laiqian.util.n;

class cg implements View.OnClickListener {
  cg(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void onClick(View paramView) {
    c c = (c)paramView.getTag();
    if (c.aTv == (PosActivitySettlementDialog.access$1700(this.bcy)).aTv)
      return; 
    int i = c.aTv;
    if (i != 10001) {
      if (i != 10009) {
        if (i != 10014) {
          switch (i) {
            default:
              PosActivitySettlementDialog.access$6500(this.bcy, c.aTv, true, false);
              return;
            case 10007:
              PosActivitySettlementDialog.access$6500(this.bcy, c.aTv, true, false);
              return;
            case 10006:
              break;
          } 
          if (!PosActivitySettlementDialog.access$1000(this.bcy).OE()) {
            PosActivitySettlementDialog.access$6300(this.bcy);
            return;
          } 
        } else {
          PosActivitySettlementDialog.access$6500(this.bcy, c.aTv, true, true);
          if (PosActivitySettlementDialog.access$6600(this.bcy)) {
            n.performClick(PosActivitySettlementDialog.access$1600(this.bcy));
            return;
          } 
        } 
      } else {
        PosActivitySettlementDialog.access$6500(this.bcy, c.aTv, true, false);
        return;
      } 
    } else {
      this.bcy.setPayTypeCash();
      PosActivitySettlementDialog.access$6400(this.bcy);
      n.j(PosActivitySettlementDialog.access$2900(this.bcy));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */