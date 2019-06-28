package com.laiqian.sync.view;

import android.os.Handler;
import android.os.Message;

class p extends Handler {
  p(Sync paramSync) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (Sync.a(this.dqo).getVisibility() == 0) {
      Sync.a(this.dqo).setVisibility(8);
      Sync.b(this.dqo).setText(this.dqo.getString(2131625621));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */