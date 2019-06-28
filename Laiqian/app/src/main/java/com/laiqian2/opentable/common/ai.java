package com.laiqian.opentable.common;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

class ai extends TimerTask {
  ai(ah paramah, Handler paramHandler, ah.a parama) {}
  
  public void run() {
    Message message = new Message();
    if (this.bZs.bMf) {
      message.what = 1;
    } else {
      message.what = 0;
    } 
    if (this.bZq != null)
      this.bZq.sendMessage(message); 
    if (!this.bZs.bMf && this.bZr != null)
      this.bZr.XW(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */