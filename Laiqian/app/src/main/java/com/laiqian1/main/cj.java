package com.laiqian.main;

import android.view.View;
import android.widget.TextView;
import com.laiqian.util.n;

class cj implements View.OnClickListener {
  cj(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void onClick(View paramView) {
    String str = ((TextView)paramView).getText().toString();
    if (str.length() > 0 && PosActivitySettlementDialog.access$2900(this.bcy).isFocusableInTouchMode()) {
      PosActivitySettlementDialog.access$2900(this.bcy).setText(str);
      n.j(PosActivitySettlementDialog.access$2900(this.bcy));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */