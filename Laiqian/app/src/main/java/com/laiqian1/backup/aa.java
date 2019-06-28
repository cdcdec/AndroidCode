package com.laiqian.backup;

import com.google.a.a.a.a.a.a;
import com.laiqian.sync.a;
import java.io.File;

class aa implements Runnable {
  aa(BackUpSystemHaltedActivity paramBackUpSystemHaltedActivity, String paramString, File paramFile) {}
  
  public void run() {
    try {
      a.b("91laiqian-error-log/system-crash", this.aIn, this.aIo);
      this.aIm.aHe.obtainMessage(1).sendToTarget();
      return;
    } catch (Exception exception) {
      this.aIm.aHe.obtainMessage(1, this.aIm.getString(2131626484)).sendToTarget();
      a.e(exception);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */