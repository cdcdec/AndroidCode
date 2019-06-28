package com.laiqian.main;

import android.view.View;

class ck implements View.OnFocusChangeListener {
  ck(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean && PosActivitySettlementDialog.access$1700(this.bcy) != null && (PosActivitySettlementDialog.access$1700(this.bcy)).aTv == 10001 && PosActivitySettlementDialog.access$5100(this.bcy)) {
      PosActivitySettlementDialog posActivitySettlementDialog;
      if (paramView == (posActivitySettlementDialog = this.bcy).access$6800(this.bcy)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      PosActivitySettlementDialog.access$5202(posActivitySettlementDialog, paramBoolean);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */