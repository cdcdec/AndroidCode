package com.laiqian.pos.industry.weiorder.auth;

import android.os.Handler;
import android.os.Message;

class h extends Handler {
  h(WechatAutoActivity paramWechatAutoActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 1)
      return; 
    this.cyd.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\auth\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */