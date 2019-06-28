package com.laiqian.login.view;

import android.os.Handler;
import android.os.Message;

class z extends Handler {
  z(LoginActivity paramLoginActivity) {}
  
  public void handleMessage(Message paramMessage) {
    LoginActivity loginActivity;
    if (paramMessage.what == 1) {
      if (this.aZD.aZy <= this.aZD.aZx) {
        this.aZD.aZg.aZT.setText(this.aZD.aZw.substring(0, this.aZD.aZy));
        loginActivity = this.aZD;
        loginActivity.aZy++;
        this.aZD.aZv.sendEmptyMessageDelayed(1, 20L);
        return;
      } 
    } else if (loginActivity.what == 2) {
      if (this.aZD.aZz >= 1 && this.aZD.aZz <= this.aZD.aZx) {
        this.aZD.aZg.aZT.setText(this.aZD.aZw.substring(0, this.aZD.aZz));
        loginActivity = this.aZD;
        loginActivity.aZz--;
        this.aZD.aZv.sendEmptyMessageDelayed(2, 20L);
        return;
      } 
      this.aZD.aZg.aZT.setVisibility(8);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */