package com.laiqian.sync.view;

import android.os.Handler;
import android.os.Message;

class k extends Handler {
  k(Sync paramSync) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (Sync.dqi < 100)
      Sync.dqi++; 
    this.dqo.gH(Sync.dqi);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */