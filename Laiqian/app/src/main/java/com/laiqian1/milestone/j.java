package com.laiqian.milestone;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.util.au;
import com.laiqian.util.av;
import java.util.HashMap;

class j extends Handler {
  j(inputFeedback paraminputFeedback) {}
  
  public void handleMessage(Message paramMessage) {
    HashMap hashMap;
    switch (paramMessage.what) {
      case 2:
        Toast.makeText(this.bKI, this.bKI.getString(2131628460), 1).show();
        hashMap = au.qB(String.valueOf(paramMessage.obj));
        if ("TRUE".equals((String)hashMap.get("bIsSuccess")))
          (new av(this.bKI)).bl((String)hashMap.get("sUpgradeDescOfFeedback"), (String)hashMap.get("sFeedbackType")); 
        this.bKI.bKG.setText("");
        this.bKI.finish();
        break;
      case 1:
        Toast.makeText(this.bKI, this.bKI.getString(2131628442), 1).show();
        break;
      case 0:
        Toast.makeText(this.bKI, this.bKI.getString(2131628459), 1).show();
        break;
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */