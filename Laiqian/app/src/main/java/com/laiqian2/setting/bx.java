package com.laiqian.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class bx extends BroadcastReceiver {
  bx(SettingOrderDishesFragment paramSettingOrderDishesFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) { Log.e("orderTypeReceiver", "orderTypeReceiver"); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */