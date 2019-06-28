package com.laiqian;

import android.os.Handler;
import android.os.Message;
import com.laiqian.payment.R;

class p extends Handler {
  p(o paramo) {}
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 987654) {
      switch (i) {
        default:
          return;
        case 4:
          if (this.aBa.aAP != null) {
            this.aBa.aAP.bl(this.aBa.onlinePayEntity.xq());
            return;
          } 
          return;
        case 3:
          this.aBa.aAD.g(0, this.aBa.aAA.getString(R.string.pay_status_manual_cancel));
          return;
        case 2:
          this.aBa.aAD.g(0, this.aBa.aAA.getString(R.string.pay_status_manual_confirm));
          if (this.aBa.aAP != null) {
            this.aBa.aAP.f(2, "手动确认扣款");
            return;
          } 
          return;
        case 1:
          break;
      } 
      if (this.aBa.aAP != null) {
        this.aBa.aAP.bl(this.aBa.onlinePayEntity.xq());
        return;
      } 
    } else {
      this.aBa.bh(paramMessage.obj.toString());
      if (this.aBa.aAP != null)
        this.aBa.aAP.f(987654, paramMessage.obj.toString()); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */