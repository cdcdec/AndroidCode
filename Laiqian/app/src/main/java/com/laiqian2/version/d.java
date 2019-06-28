package com.laiqian.version;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.au;
import com.laiqian.util.av;
import java.util.HashMap;

class d extends Handler {
  d(UpgradeAndEvaluate paramUpgradeAndEvaluate) {}
  
  public void handleMessage(Message paramMessage) {
    HashMap hashMap;
    switch (paramMessage.what) {
      case 2:
        hashMap = au.qB(String.valueOf(paramMessage.obj));
        if ("TRUE".equals((String)hashMap.get("bIsSuccess")))
          (new av(this.dIp)).bl((String)hashMap.get("sUpgradeDescOfFeedback"), (String)hashMap.get("sFeedbackType")); 
        break;
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */