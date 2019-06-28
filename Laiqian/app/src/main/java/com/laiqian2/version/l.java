package com.laiqian.version;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.ch;

class l extends Handler {
  l(UpgradeAndEvaluate paramUpgradeAndEvaluate) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    String str = (String)paramMessage.obj;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mRet=");
    stringBuilder.append(str);
    bb.ao(stringBuilder.toString());
    Message message = new Message();
    message.what = 5;
    this.dIp.dIl.sendMessage(message);
    if ("1".equals(str)) {
      av av = new av(this.dIp);
      av.hw(false);
      av.close();
      ch.ck(this.dIp);
      return;
    } 
    Toast.makeText(this.dIp, this.dIp.getString(R.string.pos_package_download_failed), 1000).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */