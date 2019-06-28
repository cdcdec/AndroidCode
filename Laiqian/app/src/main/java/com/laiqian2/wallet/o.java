package com.laiqian.wallet;

import android.content.Intent;
import android.view.View;

class o implements View.OnClickListener {
  o(Withdrawals paramWithdrawals) {}
  
  public void onClick(View paramView) {
    this.dLH.startActivity(new Intent(this.dLH, BindingAlipay.class));
    this.dLH.overridePendingTransition(R.anim.wallet_bindind_alipay_enter, R.anim.pos_nomove);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */