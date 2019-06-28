package com.laiqian.main;

import android.view.View;
import com.laiqian.entity.v;

class ch implements View.OnClickListener {
  ch(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void onClick(View paramView) {
    PosActivitySettlementDialog.access$4300(this.bcy).dismiss();
    v v = (v)paramView.getTag();
    PosActivitySettlementDialog.access$6700(this.bcy, v);
    PosActivitySettlementDialog.access$6500(this.bcy, v.aSX, true, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */