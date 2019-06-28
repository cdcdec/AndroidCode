package com.laiqian.crash.model;

import android.content.Intent;
import com.laiqian.message.k;

class f implements k.b {
  f(CrashApplication paramCrashApplication) {}
  
  public boolean ci(String paramString) { return "NOTIFICATION".equals(paramString); }
  
  public void cj(String paramString) {
    Intent intent = new Intent();
    intent.setAction("accept_customer_message_notification");
    intent.putExtra("notification_message", paramString);
    this.aMZ.sendBroadcast(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\model\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */