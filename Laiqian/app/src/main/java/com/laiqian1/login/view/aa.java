package com.laiqian.login.view;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.ch;
import com.orhanobut.logger.d;

class aa extends Handler {
  aa(LoginActivity paramLoginActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    String str = (String)paramMessage.obj;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" Landi install interface feedback result is ");
    stringBuilder.append(str);
    bb.e("_Upgrade", stringBuilder.toString());
    if ("1".equals(str)) {
      av av = new av(this.aZD);
      av.hw(false);
      av.close();
      ch.ck(this.aZD);
      d.b("downloadAPKHandler install apk", new Object[0]);
      return;
    } 
    Toast.makeText(this.aZD, "升级包下载失败.", 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */