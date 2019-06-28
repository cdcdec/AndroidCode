package com.laiqian.main;

import android.view.View;

class bf implements View.OnClickListener {
  bf(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void onClick(View paramView) {
    if (PosActivitySettlementDialog.access$000(this.bcy) && PosActivitySettlementDialog.access$100(this.bcy) != null) {
      PosActivitySettlementDialog.access$100(this.bcy).LL();
      return;
    } 
    this.bcy.cancel();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */