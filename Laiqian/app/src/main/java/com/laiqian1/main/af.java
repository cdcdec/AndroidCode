package com.laiqian.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class af extends BroadcastReceiver {
  af(PosActivity paramPosActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if ("action_openbox".equals(paramIntent.getAction()))
      PosActivity.f(this.baU); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */