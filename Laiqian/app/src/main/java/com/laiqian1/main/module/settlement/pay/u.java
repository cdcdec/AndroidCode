package com.laiqian.main.module.settlement.pay;

import android.view.View;
import com.laiqian.entity.v;

class u implements View.OnClickListener {
  u(PosActivitySettlementDialogPayTypeFragment.b paramb) {}
  
  public void onClick(View paramView) {
    this.boU.otherPayWindow.dismiss();
    v v = (v)paramView.getTag();
    this.boU.boT.am(v);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pa\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */