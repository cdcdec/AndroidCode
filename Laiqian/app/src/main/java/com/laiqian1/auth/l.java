package com.laiqian.auth;

import android.view.View;

class l implements Runnable {
  l(AuthSetting paramAuthSetting) {}
  
  public void run() {
    AuthSetting.c(this.aDF).scrollTo(0, AuthSetting.b(this.aDF));
    View view = AuthSetting.d(this.aDF).getChildAt(AuthSetting.d(this.aDF).getChildCount() - 1);
    AuthSetting.a(this.aDF, view);
    AuthSetting.a(this.aDF, 0);
    AuthSetting.a(this.aDF).setVisibility(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */