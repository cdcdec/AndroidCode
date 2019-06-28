package com.laiqian.main.module.settlement;

import android.view.View;
import android.widget.TextView;

class ae implements View.OnClickListener {
  ae(PosActivitySettlementDialogFragment.a parama) {}
  
  public void onClick(View paramView) {
    String str = ((TextView)paramView).getText().toString();
    if (str.length() > 0 && this.bmw.bmh.isFocusableInTouchMode())
      this.bmw.aAq.am(str); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */