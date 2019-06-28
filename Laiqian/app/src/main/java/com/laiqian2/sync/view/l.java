package com.laiqian.sync.view;

import android.os.Message;
import com.laiqian.sync.model.SyncProgessMessage;
import java.util.TimerTask;

class l extends TimerTask {
  l(Sync paramSync) {}
  
  public void run() {
    Message message = Message.obtain();
    message.what = 1;
    if (Sync.dqi < SyncProgessMessage.COMPLETE - 1) {
      Sync.e(this.dqo).sendMessage(message);
      return;
    } 
    Sync.f(this.dqo);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */