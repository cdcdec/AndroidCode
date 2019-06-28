package com.laiqian.auth;

import android.view.View;

class r implements View.OnClickListener {
  r(AuthSetting paramAuthSetting) {}
  
  public void onClick(View paramView) {
    if (paramView.isActivated()) {
      AuthSetting.n(this.aDF);
      return;
    } 
    AuthSetting.b(this.aDF, (View)paramView.getTag());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */