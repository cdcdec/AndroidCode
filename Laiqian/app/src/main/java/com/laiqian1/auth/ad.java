package com.laiqian.auth;

import android.view.View;
import com.laiqian.member.bz;

class ad implements View.OnFocusChangeListener {
  ad(ModifyUserPasswordDialog paramModifyUserPasswordDialog) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      bz bz;
      if ((bz = this.aEe.aDP).aE(ModifyUserPasswordDialog.d(this.aEe))) {
        this.aEe.aDP = bz.Qw();
        this.aEe.aDP.a(ModifyUserPasswordDialog.d(this.aEe), 500L, this.aEe.aDQ);
        this.aEe.aDP.start();
        return;
      } 
      if (this.aEe.aDP != null) {
        this.aEe.aDP.stop();
        return;
      } 
    } else if (this.aEe.aDP != null) {
      this.aEe.aDP.stop();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */