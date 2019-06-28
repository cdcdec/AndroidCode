package com.laiqian.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

class ab extends BroadcastReceiver {
  ab(PosActivity paramPosActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if ("pos_change_account".equals(paramIntent.getAction())) {
      Toast.makeText(paramContext, 2131624146, 0).show();
      PosActivity.c(this.baU);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */