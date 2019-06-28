package com.laiqian.main.module.settlement;

import android.view.KeyEvent;
import android.view.View;
import com.laiqian.util.n;

class af implements View.OnClickListener {
  af(PosActivitySettlementDialogFragment.a parama) {}
  
  public void onClick(View paramView) {
    int i = n.parseInt(paramView.getTag().toString());
    this.bmw.dispatchKeyEvent(new KeyEvent(false, i));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */