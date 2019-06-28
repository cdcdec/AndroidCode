package com.laiqian.wallet;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

class n extends Handler {
  n(WalletSettingFragment paramWalletSettingFragment) {}
  
  public void handleMessage(Message paramMessage) {
    String str;
    WalletSettingFragment.d(this.dLr).setVisibility(8);
    int i = paramMessage.what;
    if (i != -1) {
      String[] arrayOfString;
      if (i != 1)
        return; 
      WalletSettingFragment.e(this.dLr).setVisibility(8);
      str = (String[])paramMessage.obj;
      WalletSettingFragment.f(this.dLr).setText(str[0]);
      WalletSettingFragment.g(this.dLr).setVisibility(0);
      WalletSettingFragment.h(this.dLr).setVisibility(0);
      WalletSettingFragment.i(this.dLr).setText(str[1]);
      WalletSettingFragment.j(this.dLr).setText(str[2]);
      return;
    } 
    WalletSettingFragment.e(this.dLr).setVisibility(0);
    TextView textView = WalletSettingFragment.e(this.dLr);
    if (str.obj == null) {
      str = "";
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str.obj);
      stringBuilder.append("");
      str = stringBuilder.toString();
    } 
    textView.setText(str);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */