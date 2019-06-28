package com.laiqian.auth;

import android.os.Message;
import com.laiqian.sync.c.a;

class bp implements Runnable {
  bp(UserManagement paramUserManagement) {}
  
  public void run() {
    UserManagement.u(this.aGm).apy().gW(true);
    boolean bool = UserManagement.u(this.aGm).b(true, a.dpq, 0L, System.currentTimeMillis());
    Message message = new Message();
    message.obj = Boolean.valueOf(bool);
    this.aGm.uploadHandler.sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */