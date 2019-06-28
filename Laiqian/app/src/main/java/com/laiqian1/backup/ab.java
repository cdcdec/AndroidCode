package com.laiqian.backup;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.n;

class ab extends Handler {
  ab(BackUpSystemHaltedActivity paramBackUpSystemHaltedActivity) {}
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what == 1) {
      BackUpSystemHaltedActivity.d(this.aIm).cancel();
      if (paramMessage.obj == null) {
        n.w(this.aIm.getApplicationContext(), 2131626486);
        BackUpSystemHaltedActivity.a(this.aIm).dismiss();
        return;
      } 
      BackUpSystemHaltedActivity.a(this.aIm, this.aIm.getString(2131626487));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */