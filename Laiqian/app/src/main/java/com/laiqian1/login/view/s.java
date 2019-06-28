package com.laiqian.login.view;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.bb;

class s extends Handler {
  s(LoginActivity paramLoginActivity) {}
  
  public void handleMessage(Message paramMessage) {
    if (((Boolean)paramMessage.obj).booleanValue()) {
      bb.fU("直接从下载服务器下载文件成功.");
      boolean bool = LoginActivity.i(this.aZD).b(this.aZD.aZq);
      Message message1 = new Message();
      message1.obj = Boolean.valueOf(bool);
      message1.what = paramMessage.what;
      this.aZD.aZt.sendMessage(message1);
      return;
    } 
    bb.fU("直接从下载服务器下载文件失败.");
    Message message = new Message();
    message.what = paramMessage.what;
    this.aZD.aZu.sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */