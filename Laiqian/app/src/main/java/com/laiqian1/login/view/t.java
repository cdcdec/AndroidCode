package com.laiqian.login.view;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.laiqian.util.av;
import com.laiqian.util.bb;

class t extends Handler {
  t(LoginActivity paramLoginActivity) {}
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    String str = LoginActivity.Ky();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MultithreadOSSDownloadHandler = ");
    stringBuilder.append(paramMessage.what);
    Log.e(str, stringBuilder.toString());
    if (i == 1) {
      bb.fU("OSS下载文件成功.开始合并下载文件. ");
      boolean bool = LoginActivity.i(this.aZD).b(this.aZD.aZq);
      Message message = new Message();
      message.obj = Boolean.valueOf(bool);
      message.what = paramMessage.what;
      this.aZD.aZt.sendMessage(message);
      return;
    } 
    if (i == 0) {
      bb.fU("OSS下载文件失败. 重新开始验证过程，并从下载服务器下载文件. ");
      av av = new av(this.aZD);
      av.hK(true);
      av.close();
      this.aZD.Ko();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */