package com.laiqian.login.view;

import com.laiqian.util.by;

class u implements Runnable {
  u(LoginActivity paramLoginActivity) {}
  
  public void run() {
    if (by.isNull(this.aZD.aZg.aZI.getText().toString())) {
      this.aZD.aZg.aZI.requestFocus();
      return;
    } 
    this.aZD.aZg.aZK.requestFocus();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\vie\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */