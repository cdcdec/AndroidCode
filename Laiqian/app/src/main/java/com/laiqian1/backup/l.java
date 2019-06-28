package com.laiqian.backup;

import android.os.Handler;
import android.os.Message;
import io.reactivex.g.a;
import java.io.File;

class l extends Handler {
  l(BackUpRootActivity paramBackUpRootActivity) {}
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what != 1) {
      File file = new File(this.aHq.aGK);
      if (!file.exists() || !file.isDirectory() || !file.canWrite()) {
        BackUpRootActivity.f(this.aHq);
        return;
      } 
      BackUpRootActivity.i(this.aHq);
    } else {
      Message message = new Message();
      message.obj = "start";
      this.aHq.aHm.sendMessage(message);
      m m = new m(this);
      a.aKh().r(m);
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */