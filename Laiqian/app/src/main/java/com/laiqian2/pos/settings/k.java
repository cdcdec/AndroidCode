package com.laiqian.pos.settings;

import android.os.Handler;
import android.os.Message;

class k extends Handler {
  k(InitialSettingsActivity paramInitialSettingsActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 4:
        if (InitialSettingsActivity.j(this.czu).isShowing()) {
          InitialSettingsActivity.j(this.czu).dismiss();
          return;
        } 
        return;
      case 3:
        if (!InitialSettingsActivity.j(this.czu).isShowing()) {
          InitialSettingsActivity.j(this.czu).show();
          return;
        } 
        return;
      case 1:
        InitialSettingsActivity.k(this.czu).obtainMessage(4).sendToTarget();
        InitialSettingsActivity.m(this.czu).show();
        return;
      case 0:
        break;
    } 
    InitialSettingsActivity.k(this.czu).obtainMessage(4).sendToTarget();
    InitialSettingsActivity.l(this.czu);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */