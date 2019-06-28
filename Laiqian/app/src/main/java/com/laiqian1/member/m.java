package com.laiqian.member;

import android.os.Handler;
import android.os.Message;

class m extends Handler {
  m(MemberChangeActivity paramMemberChangeActivity) {}
  
  public void handleMessage(Message paramMessage) {
    if (!"".equals(String.valueOf(paramMessage.obj))) {
      this.btq.bsA.setText(String.valueOf(paramMessage.obj));
      if (this.btq.bsA.hasFocus())
        this.btq.bsF.requestFocus(); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */