package com.laiqian.wallet;

import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.by;
import com.laiqian.util.n;

class t implements View.OnClickListener {
  t(Withdrawals paramWithdrawals) {}
  
  public void onClick(View paramView) {
    if (Withdrawals.e(this.dLH).getVisibility() == 0) {
      n.w(this.dLH, R.string.pos_wallet_reflect_executing_noWorry);
      return;
    } 
    if (by.parseDouble(Withdrawals.b(this.dLH).getText().toString().trim()) <= 0.0D) {
      n.w(this.dLH, R.string.cash_withdrawal_amount);
      return;
    } 
    str = Withdrawals.c(this.dLH).getText().toString().trim();
    if (!by.isNull(str) && str.equals(RootApplication.getLaiqianPreferenceManager().auN())) {
      try {
        Withdrawals.f(this.dLH);
      } catch (Exception str) {
        a.e(str);
      } 
      Withdrawals.g(this.dLH).setVisibility(8);
      Withdrawals.e(this.dLH).setVisibility(0);
      return;
    } 
    n.eP(R.string.wrongpassword);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */