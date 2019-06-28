package com.laiqian.login.a;

import android.os.Handler;
import android.os.Message;

class q extends Handler {
  q(b paramb) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    b.a(this.aXX);
    switch (paramMessage.what) {
      default:
        return;
      case 1:
        b.c(this.aXX).s(String.valueOf(paramMessage.obj));
        b.c(this.aXX).setTitle(b.b(this.aXX).getString(2131625960));
        b.g(this.aXX);
        return;
      case 0:
        break;
    } 
    b.h(this.aXX);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */