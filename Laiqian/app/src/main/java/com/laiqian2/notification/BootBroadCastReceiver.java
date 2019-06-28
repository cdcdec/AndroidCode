package com.laiqian.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;

public class BootBroadCastReceiver extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
      paramContext.getApplicationContext();
      PreferenceManager.getDefaultSharedPreferences(paramContext);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\notification\BootBroadCastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */