package com.laiqian.pos.hold;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aj extends BroadcastReceiver {
  aj(ai paramai) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if ("pos_activity_change_data_takeorderscount".equals(paramIntent.getAction())) {
      (ai.b(this.cpW)).cpZ.setText(ai.a(this.cpW));
      ai.c(this.cpW);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */