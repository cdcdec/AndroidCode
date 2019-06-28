package com.laiqian.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class i {
  private Handler dET;
  
  private Looper dEU;
  
  public void post(Runnable paramRunnable) {
    if (this.dET == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append(getClass());
      stringBuilder.append("]");
      HandlerThread handlerThread = new HandlerThread(stringBuilder.toString());
      handlerThread.start();
      this.dEU = handlerThread.getLooper();
      this.dET = new Handler(this.dEU);
    } 
    this.dET.post(paramRunnable);
  }
  
  public void quit() {
    if (this.dET != null) {
      this.dEU.quit();
      this.dET = null;
      this.dEU = null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */