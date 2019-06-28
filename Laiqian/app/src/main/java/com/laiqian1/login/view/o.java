package com.laiqian.login.view;

import android.view.View;
import com.laiqian.member.bz;

class o implements View.OnFocusChangeListener {
  o(LoginActivity paramLoginActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      bz bz;
      if ((bz = this.aZD.aDP).aE(this.aZD)) {
        this.aZD.aDP = bz.Qw();
        this.aZD.aDP.a(this.aZD, 500L, this.aZD.aDQ);
        this.aZD.aDP.start();
        return;
      } 
      if (this.aZD.aDP != null) {
        this.aZD.aDP.stop();
        return;
      } 
    } else if (this.aZD.aDP != null) {
      this.aZD.aDP.stop();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */