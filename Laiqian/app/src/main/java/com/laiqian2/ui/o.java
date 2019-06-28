package com.laiqian.ui;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.util.au;
import com.laiqian.util.av;
import java.util.HashMap;

class o extends Handler {
  o(m paramm) {}
  
  public void handleMessage(Message paramMessage) {
    HashMap hashMap;
    String str;
    switch (paramMessage.what) {
      case 2:
        Toast.makeText(m.b(this.dwr), m.b(this.dwr).getString(R.string.pos_upgrade_thanks_for_your_feedback), 1).show();
        hashMap = au.qB(String.valueOf(paramMessage.obj));
        if (hashMap == null)
          return; 
        str = "FALSE";
        if (hashMap.containsKey("bIsSuccess"))
          str = (String)hashMap.get("bIsSuccess"); 
        if ("TRUE".equals(str)) {
          av av = new av(m.b(this.dwr));
          if (hashMap.containsKey("sUpgradeDescOfFeedback") && hashMap.containsKey("sFeedbackType"))
            av.bl((String)hashMap.get("sUpgradeDescOfFeedback"), (String)hashMap.get("sFeedbackType")); 
        } 
        break;
      case 1:
        Toast.makeText(m.b(this.dwr), m.b(this.dwr).getString(R.string.pos_upgrade_check_network), 1).show();
        break;
      case 0:
        Toast.makeText(m.b(this.dwr), m.b(this.dwr).getString(R.string.pos_upgrade_server_process_fail), 1).show();
        break;
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */