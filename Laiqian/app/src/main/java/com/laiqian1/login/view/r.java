package com.laiqian.login.view;

import android.os.Message;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;

class r implements Runnable {
  r(LoginActivity paramLoginActivity) {}
  
  public void run() {
    message = new Message();
    try {
      LoginActivity.i(this.aZD).apz().init();
      LoginActivity.i(this.aZD).apx().init();
      av av = new av(this.aZD);
      boolean bool1 = av.ava();
      boolean bool = false;
      if (bool1) {
        LoginActivity.i(this.aZD).apz().gX(false);
      } else {
        LoginActivity.i(this.aZD).apz().gX(true);
      } 
      null = this.aZD.aZg.aZI.getText().toString().trim();
      String str = this.aZD.aZg.aZK.getText().toString().trim();
      this.aZD.aZq = LoginActivity.i(this.aZD).aW(null, str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("syncResponse value is: ");
      stringBuilder.append(this.aZD.aZq);
      bb.fU(stringBuilder.toString());
      message.obj = this.aZD.aZq;
      if (this.aZD.aZq == null) {
        bb.fU("服务器返回空. 验证出错 ");
        this.aZD.aZu.sendMessage(Message.obtain(message));
        return;
      } 
      if (this.aZD.aZq.apM()) {
        bb.fU("服务器账号和密码验证通过 ");
        av.qG(this.aZD.aZq.aDZ);
        if (this.aZD.aZq.apO()) {
          if (LoginActivity.i(this.aZD).apz().apK()) {
            bb.fU("开始从OSS下载文件 ");
            bool1 = LoginActivity.i(this.aZD).e(this.aZD.aZs);
            if (!bool1) {
              String str1 = getClass().getName();
              stringBuilder = new StringBuilder();
              stringBuilder.append(bool1);
              stringBuilder.append("");
              h.a(new d(str1, "verifyPasswordOnline", "OSS下载文件结果", stringBuilder.toString()), h.a.dHv, h.b.dHF);
            } 
          } else {
            bb.fU("不走oss 服务器下载, 直接从下载服务器下载.");
            bool1 = LoginActivity.i(this.aZD).apA();
            if (!bool1) {
              String str1 = getClass().getName();
              stringBuilder = new StringBuilder();
              stringBuilder.append("");
              stringBuilder.append(bool1);
              h.a(new d(str1, "LoginResultverifyPasswordOnline", "服务器下载文件", stringBuilder.toString()), h.a.dHv, h.b.dHF);
            } 
            message.obj = Boolean.valueOf(bool1);
            this.aZD.aZr.sendMessage(message);
          } 
        } else {
          LoginActivity.a(this.aZD, true);
        } 
        bool = true;
      } 
      if (!bool) {
        this.aZD.aZu.sendMessage(Message.obtain(message));
        return;
      } 
    } catch (Exception message) {
      h.a(new d(getClass().getName(), "verifyPasswordOnline", "exception", message.toString()), h.a.dHw, h.b.dHF);
      a.e(message);
    } finally {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */