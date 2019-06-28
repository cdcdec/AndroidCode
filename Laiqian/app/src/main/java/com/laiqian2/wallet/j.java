package com.laiqian.wallet;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

class j extends TimerTask {
  j(i parami, Handler paramHandler, i.a parama) {}
  
  public void run() {
    Message message = new Message();
    if (this.dLc.bMf) {
      message.what = 1;
    } else {
      message.what = 0;
    } 
    if (this.bZq != null)
      this.bZq.sendMessage(message); 
    if (!this.dLc.bMf && this.dLb != null)
      this.dLb.XW(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */