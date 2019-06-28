package com.laiqian.main;

import android.view.KeyEvent;
import android.view.View;
import com.laiqian.util.n;

class ci implements View.OnClickListener {
  ci(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void onClick(View paramView) {
    int i = n.parseInt(paramView.getTag().toString());
    this.bcy.dispatchKeyEvent(new KeyEvent(false, i));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */