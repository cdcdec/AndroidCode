package com.laiqian.login.view;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.laiqian.print.dualscreen.DualScreenService;

class ag implements ServiceConnection {
  ag(LoginActivity paramLoginActivity) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    LoginActivity.a(this.aZD, ((DualScreenService.a)paramIBinder).afE());
    LoginActivity.a(this.aZD, LoginActivity.a(this.aZD).afD());
    LoginActivity.b(this.aZD).fA(false);
    LoginActivity.b(this.aZD).afP().v(this.aZD.getResources().getDrawable(2131231913));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    LoginActivity.a(this.aZD, null);
    LoginActivity.a(this.aZD, null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */