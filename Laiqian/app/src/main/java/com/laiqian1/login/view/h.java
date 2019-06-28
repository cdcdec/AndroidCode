package com.laiqian.login.view;

import android.os.Handler;
import android.os.Message;

class h extends Handler {
  h(LoginActivity paramLoginActivity) {}
  
  public void handleMessage(Message paramMessage) {
    if (!"".equals(String.valueOf(paramMessage.obj))) {
      this.aZD.aZg.aZK.setText(String.valueOf(paramMessage.obj));
      if (this.aZD.aZg.aZK.hasFocus())
        this.aZD.aZg.aZK.requestFocus(); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */