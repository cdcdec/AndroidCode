package com.laiqian.report.ui;

import android.os.Handler;
import android.os.Message;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;

class t extends Handler {
  t(OrderDetailsByReturn paramOrderDetailsByReturn) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    null = this.deB;
    boolean bool = false;
    null.showWaitingDialog(false);
    if (paramMessage.what != 66)
      return; 
    OrderDetailsByReturn.a(this.deB, false);
    null = new StringBuilder();
    null.append("团购券撤销的成功数量：");
    null.append(paramMessage.arg1);
    null.append("，失败的数量：");
    null.append(paramMessage.arg2);
    n.println(null.toString());
    if (paramMessage.arg2 == 0) {
      this.deB.returnFull(null);
      return;
    } 
    r r = new r(this.deB, new u(this));
    if (paramMessage.arg1 == 0)
      bool = true; 
    r.setCancelable(bool);
    r.setTitle(this.deB.getString(2131626721));
    if (paramMessage.obj != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramMessage.obj);
      stringBuilder.append("");
      r.s(stringBuilder.toString());
    } else {
      r.s(this.deB.getString(2131627331));
    } 
    r.oZ(this.deB.getString(2131626716));
    r.t(this.deB.getString(2131627332));
    r.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */