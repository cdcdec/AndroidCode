package com.laiqian.main.module.settlement.pay;

import android.view.View;
import com.laiqian.main.b.c;

class t implements View.OnClickListener {
  t(PosActivitySettlementDialogPayTypeFragment.a parama) {}
  
  public void onClick(View paramView) {
    c c = (c)paramView.getTag();
    if (c != null)
      this.boR.aAq.am(c); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */