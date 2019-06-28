package com.laiqian.login.view;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.bb;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;

class v extends Handler {
  v(LoginActivity paramLoginActivity) {}
  
  public void handleMessage(Message paramMessage) {
    LoginActivity.i(this.aZD).apy().gW(false);
    boolean bool = ((Boolean)paramMessage.obj).booleanValue();
    if (bool) {
      bb.fU("合并下载文件成功. ");
      this.aZD.Kp();
      return;
    } 
    bb.fU("合并下载文件失败. ");
    String str = getClass().getName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(bool);
    h.a(new d(str, "mergeDataResultHand", "合并文件", stringBuilder.toString()), h.a.dHv, h.b.dHF);
    this.aZD.aZu.sendMessage(Message.obtain(paramMessage));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */