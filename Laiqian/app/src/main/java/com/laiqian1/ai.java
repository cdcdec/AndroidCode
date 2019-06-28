package com.laiqian;

import android.os.Handler;
import android.os.Message;
import com.laiqian.payment.R;

class ai extends Handler {
  ai(ag paramag) {}
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 987654) {
      switch (i) {
        default:
          return;
        case 4:
          if (ag.a(this.aBv) != null) {
            ag.a(this.aBv).bl(ag.b(this.aBv).xq());
            return;
          } 
          return;
        case 3:
          ag.d(this.aBv).g(0, ag.c(this.aBv).getString(R.string.pay_status_manual_cancel));
          return;
        case 2:
          ag.d(this.aBv).g(0, ag.c(this.aBv).getString(R.string.pay_status_manual_confirm));
          if (ag.a(this.aBv) != null) {
            ag.a(this.aBv).f(2, "手动确认扣款");
            return;
          } 
          return;
        case 1:
          break;
      } 
      if (ag.a(this.aBv) != null) {
        ag.a(this.aBv).bl(ag.b(this.aBv).xq());
        return;
      } 
    } else {
      this.aBv.bh(paramMessage.obj.toString());
      if (ag.a(this.aBv) != null)
        ag.a(this.aBv).f(987654, paramMessage.obj.toString()); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */