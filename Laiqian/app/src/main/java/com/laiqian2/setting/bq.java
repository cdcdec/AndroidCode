package com.laiqian.setting;

import android.content.Intent;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class bq implements w.a {
  bq(bp parambp) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    SettingCashierFragment.g(this.dlY.dlV).setText(SettingCashierFragment.f(this.dlY.dlV)[paramInt]);
    CrashApplication.getLaiqianPreferenceManager().lY(paramInt);
    this.dlY.dlV.getActivity().sendBroadcast(new Intent("pos_activity_change_data_producttype"));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */