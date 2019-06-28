package com.laiqian.main;

import android.view.View;
import com.laiqian.util.n;

class cm implements View.OnClickListener {
  cm(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void onClick(View paramView) {
    if (PosActivitySettlementDialog.access$400(this.bcy)) {
      n.eP(2131627279);
      return;
    } 
    PosActivitySettlementDialog.access$600(this.bcy).requestFocus();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */