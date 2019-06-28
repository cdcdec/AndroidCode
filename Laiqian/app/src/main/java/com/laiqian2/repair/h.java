package com.laiqian.repair;

import android.os.Message;

class h extends Thread {
  h(g paramg) {}
  
  public void run() {
    f.a(this.cYe.cYd, getName());
    String str = this.cYe.cYd.a(f.a(this.cYe.cYd));
    if (getName() != f.e(this.cYe.cYd))
      return; 
    if (this.cYe.cYd.mActivity.isFinishing()) {
      f.f(this.cYe.cYd).sendEmptyMessage(0);
      return;
    } 
    Message message = new Message();
    message.what = 1;
    message.obj = str;
    message.arg1 = (f.a(this.cYe.cYd)).id;
    f.f(this.cYe.cYd).sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repair\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */