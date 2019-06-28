package com.laiqian.member.a;

import android.os.Handler;
import android.os.Message;
import com.laiqian.vip.R;

class j extends Handler {
  j(a parama) {}
  
  public void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return;
      case 3:
        this.bwR.bwG.a(a.j(this.bwR).getString(R.string.pay_status_pending), a.h(this.bwR), a.k(this.bwR), true, false);
        return;
      case 2:
        if (a.g(this.bwR)) {
          a.a(this.bwR, paramMessage);
          this.bwR.QD();
          this.bwR.bwG.a(a.i(this.bwR).getString(R.string.pay_status_pending), a.h(this.bwR), this.bwR.bwz, true, true);
          return;
        } 
        return;
      case 1:
        break;
    } 
    if (a.g(this.bwR)) {
      a.a(this.bwR, paramMessage);
      this.bwR.QD();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */