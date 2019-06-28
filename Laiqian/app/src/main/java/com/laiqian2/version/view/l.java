package com.laiqian.version.view;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.ch;

class l extends Handler {
  l(LegacyUpgradeAndEvaluate paramLegacyUpgradeAndEvaluate) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    String str = (String)paramMessage.obj;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mRet=");
    stringBuilder.append(str);
    bb.ao(stringBuilder.toString());
    Message message = new Message();
    message.what = 5;
    this.dKa.dIl.sendMessage(message);
    if ("1".equals(str)) {
      av av = new av(this.dKa);
      av.hw(false);
      av.close();
      ch.ck(this.dKa);
      return;
    } 
    Toast.makeText(this.dKa, this.dKa.getString(R.string.pos_package_download_failed), 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */