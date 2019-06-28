package com.laiqian.main.module.misc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class n extends BroadcastReceiver {
  n(PosActivityMoreSettingsFragment paramPosActivityMoreSettingsFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if ("customer_service_reply".equals(paramIntent.getAction())) {
      this.bgP.bgJ = paramIntent.getStringExtra("version_id");
      if (this.bgP.bgJ != null) {
        this.bgP.bgK = true;
        this.bgP.bgI.bgR.aZ(true);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\misc\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */