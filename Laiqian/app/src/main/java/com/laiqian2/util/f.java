package com.laiqian.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class f extends Handler {
  f(e parame, Looper paramLooper) { super(paramLooper); }
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.what == this.dES.dEM) {
      this.dES.dEL.aK(this.dES.dEQ);
    } else {
      this.dES.dEL.aJ(this.dES.dEQ);
    } 
    this.dES.handler.removeMessages(this.dES.dEN);
    this.dES.handler.removeMessages(this.dES.dEM);
    this.dES.handler = null;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */