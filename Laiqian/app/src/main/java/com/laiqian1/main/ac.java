package com.laiqian.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.laiqian.basic.RootApplication;

class ac extends BroadcastReceiver {
  ac(PosActivity paramPosActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if ("action_meituan_phone_number_error_orders".equals(paramIntent.getAction()) && RootApplication.getLaiqianPreferenceManager().awf() && !"[]".equals(RootApplication.getLaiqianPreferenceManager().awg()) && !TextUtils.isEmpty(RootApplication.getLaiqianPreferenceManager().awg()))
      this.baU.KU(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */