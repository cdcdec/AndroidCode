package com.laiqian.member.transfer;

import android.os.Handler;
import android.os.Message;
import com.laiqian.basic.RootApplication;
import com.laiqian.vip.R;

class h extends Handler {
  h(d paramd) {}
  
  public void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return;
      case 3:
        if (Boolean.parseBoolean(String.valueOf(paramMessage.obj))) {
          d.a(this.bHx).gm(RootApplication.zv().getString(R.string.template_down_success));
          return;
        } 
        d.a(this.bHx).gn(RootApplication.zv().getString(R.string.template_down_fail));
        return;
      case 2:
        break;
    } 
    if (paramMessage.arg1 == 0) {
      d.a(this.bHx, true);
      return;
    } 
    if (paramMessage.arg1 == 1) {
      d.a(this.bHx).gn(String.valueOf(paramMessage.obj));
      return;
    } 
    if (paramMessage.arg1 == 3) {
      d.a(this.bHx, false);
      d.a(this.bHx).gn(String.valueOf(paramMessage.obj));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\transfer\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */