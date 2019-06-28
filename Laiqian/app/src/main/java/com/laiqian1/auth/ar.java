package com.laiqian.auth;

import android.os.Message;

class ar implements Runnable {
  ar(PrivilegeLimitActivity paramPrivilegeLimitActivity) {}
  
  public void run() {
    PrivilegeLimitActivity.a(this.aEm).apy().gW(true);
    boolean bool = PrivilegeLimitActivity.a(this.aEm).b(true, "t_string", 0L, System.currentTimeMillis());
    Message message = new Message();
    message.obj = Boolean.valueOf(bool);
    this.aEm.uploadHandler.sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */