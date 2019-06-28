package com.laiqian.backup;

import android.os.Message;

class m implements Runnable {
  m(l paraml) {}
  
  public void run() {
    boolean bool = ag.b(this.aHt.aHq, this.aHt.aHq.aGK, this.aHt.aHq.getString(2131624364), false);
    Message message = new Message();
    if (bool) {
      message.obj = "success";
      this.aHt.aHq.aHm.sendMessage(message);
      return;
    } 
    message.obj = "fail";
    this.aHt.aHq.aHm.sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */