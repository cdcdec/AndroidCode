package com.laiqian.member.select;

import android.os.Handler;
import android.os.Message;

class j extends Handler {
  j(PosSelectVipDialog paramPosSelectVipDialog) {}
  
  public void handleMessage(Message paramMessage) {
    if (!"".equals(String.valueOf(paramMessage.obj))) {
      this.bAG.bvb.setText(String.valueOf(paramMessage.obj));
      if (this.bAG.bvb.hasFocus())
        this.bAG.bvb.requestFocus(); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */