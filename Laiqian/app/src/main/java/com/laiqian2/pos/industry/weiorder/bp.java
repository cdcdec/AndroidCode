package com.laiqian.pos.industry.weiorder;

import android.os.Handler;
import android.os.Message;
import com.laiqian.pos.dn;
import com.laiqian.takeaway.aq;
import com.laiqian.util.bb;

class bp extends Handler {
  bp(TddSetting paramTddSetting) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 1)
      return; 
    if (TddSetting.c(this.ctU) == null)
      return; 
    TddSetting.c(this.ctU).put("sLqkUserTddShops", paramMessage.obj.toString());
    aq.b(this.ctU, TddSetting.c(this.ctU));
    TddSetting.d(this.ctU);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sShopsKey");
    stringBuilder.append(paramMessage.obj.toString());
    bb.e("sShopsKey", stringBuilder.toString());
    (new dn(this.ctU)).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */