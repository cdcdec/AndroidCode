package com.laiqian.member.create;

import android.os.Handler;
import android.os.Message;

class l extends Handler {
  l(VipCreateDialog paramVipCreateDialog) {}
  
  public void handleMessage(Message paramMessage) {
    if (!"".equals(String.valueOf(paramMessage.obj))) {
      this.bxz.bxa.setText(String.valueOf(paramMessage.obj));
      if (this.bxz.bxa.hasFocus())
        this.bxz.bwZ.requestFocus(); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */