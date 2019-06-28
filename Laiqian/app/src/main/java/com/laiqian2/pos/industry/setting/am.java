package com.laiqian.pos.industry.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class am extends BroadcastReceiver {
  am(MainSetting paramMainSetting) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    String str = paramIntent.getAction();
    if (("pos_change_account".equals(str) || "pos_shut_down".equals(str)) && !this.csj.isFinishing())
      this.csj.finish(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */