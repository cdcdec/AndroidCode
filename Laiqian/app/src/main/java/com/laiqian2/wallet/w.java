package com.laiqian.wallet;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

class w extends Handler {
  w(Withdrawals paramWithdrawals) {}
  
  public void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return;
      case 3:
        Withdrawals.f(this.dLH);
        return;
      case 2:
        Withdrawals.a(this.dLH).bn(Withdrawals.i(this.dLH).getText().toString().trim(), Withdrawals.j(this.dLH).getText().toString().trim());
        Withdrawals.m(this.dLH);
        return;
      case 1:
        Withdrawals.a(this.dLH, R.string.pos_wallet_reflect_success);
        this.dLH.findViewById(R.id.withdrawals_suc).setVisibility(0);
        if (WalletSettingFragment.dLd != null) {
          WalletSettingFragment.dLd.axA();
          return;
        } 
        return;
      case -1:
        textView = Withdrawals.l(this.dLH);
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramMessage.obj);
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        Withdrawals.g(this.dLH).setVisibility(0);
        Withdrawals.e(this.dLH).setVisibility(8);
        return;
      case -2:
        textView = Withdrawals.l(this.dLH);
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramMessage.obj);
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        Withdrawals.g(this.dLH).setVisibility(0);
        Withdrawals.e(this.dLH).setVisibility(8);
        return;
      case -3:
        break;
    } 
    TextView textView = Withdrawals.l(this.dLH);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramMessage.obj);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    Withdrawals.g(this.dLH).setVisibility(0);
    Withdrawals.e(this.dLH).setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */