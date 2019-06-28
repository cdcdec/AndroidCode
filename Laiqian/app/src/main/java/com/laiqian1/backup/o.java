package com.laiqian.backup;

import android.os.Message;
import com.google.a.a.a.a.a.a;

class o implements Runnable {
  o(n paramn) {}
  
  public void run() {
    try {
      Thread.sleep(1500L);
      Message message = new Message();
      message.what = 2;
      this.aHu.aHq.aHo.sendMessage(message);
      return;
    } catch (InterruptedException interruptedException) {
      a.e(interruptedException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */