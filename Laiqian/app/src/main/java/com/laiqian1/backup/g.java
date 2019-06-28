package com.laiqian.backup;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.n;

class g extends Handler {
  g(BackUpRootActivity paramBackUpRootActivity) {}
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what == 1) {
      BackUpRootActivity.g(this.aHq).cancel();
      if (paramMessage.obj == null) {
        n.w(this.aHq.getApplicationContext(), 2131626486);
        BackUpRootActivity.b(this.aHq).dismiss();
        return;
      } 
      BackUpRootActivity.a(this.aHq, this.aHq.getString(2131626487));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */