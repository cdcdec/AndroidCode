package com.laiqian.version;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.util.ch;
import java.util.HashMap;

class j extends Handler {
  j(UpgradeAndEvaluate paramUpgradeAndEvaluate) {}
  
  public void handleMessage(Message paramMessage) {
    HashMap hashMap = (HashMap)paramMessage.obj;
    if (ch.F(this.dIp, UpgradeAndEvaluate.c(this.dIp))) {
      Toast.makeText(this.dIp.getBaseContext(), this.dIp.getString(R.string.pos_find_new_version_please_download), 1000).show();
      UpgradeAndEvaluate.d(this.dIp);
      return;
    } 
    UpgradeAndEvaluate.e(this.dIp);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */