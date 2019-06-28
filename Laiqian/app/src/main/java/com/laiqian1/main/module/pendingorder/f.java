package com.laiqian.main.module.pendingorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;

class f extends BroadcastReceiver {
  private Time biO = new g(this);
  
  f(PosActivityPendingOrderFragment paramPosActivityPendingOrderFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    Time time = new Time();
    time.setToNow();
    if (time.yearDay != this.biO.yearDay)
      PosActivityPendingOrderFragment.b(this.biN); 
    this.biO = time;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\pendingorder\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */