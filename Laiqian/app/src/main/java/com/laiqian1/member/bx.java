package com.laiqian.member;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class bx extends Handler {
  bx(bs parambs) {}
  
  public void handleMessage(Message paramMessage) {
    this.bvW.bvO.cancel();
    if (paramMessage.obj == null) {
      if (paramMessage.arg1 == 2) {
        n.w(bs.b(this.bvW), R.string.pos_report_export_mail_send_suc);
      } else {
        n.w(bs.b(this.bvW), R.string.pos_report_export_u_suc);
      } 
      if (bs.d(this.bvW).Qm() != null)
        bs.d(this.bvW).Qm().dismiss(); 
      bs.f(this.bvW).cancel();
      return;
    } 
    if (paramMessage.arg1 == 2) {
      bs.d(this.bvW).fw(String.valueOf(paramMessage.obj));
      return;
    } 
    Activity activity = bs.b(this.bvW);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramMessage.obj);
    stringBuilder.append("");
    n.a(activity, stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */