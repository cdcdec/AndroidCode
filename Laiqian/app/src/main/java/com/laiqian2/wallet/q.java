package com.laiqian.wallet;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.laiqian.util.by;

class q implements TextWatcher {
  q(Withdrawals paramWithdrawals) {}
  
  public void afterTextChanged(Editable paramEditable) {
    boolean bool;
    double d = by.parseDouble(Withdrawals.a(this.dLH).auR().replace(",", ""));
    if (by.parseDouble(paramEditable.toString()) > d) {
      Withdrawals withdrawals = this.dLH;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(d);
      stringBuilder.append("");
      Withdrawals.a(withdrawals, stringBuilder.toString());
    } 
    View view = Withdrawals.d(this.dLH);
    if (Withdrawals.b(this.dLH).length() > 0 && Withdrawals.c(this.dLH).length() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    view.setEnabled(bool);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */