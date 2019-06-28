package com.laiqian.sync.view;

import android.os.Handler;
import android.os.Message;

class u extends Handler {
  u(TestSync paramTestSync) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    this.dqv.dqd.append(paramMessage.obj.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\vie\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */