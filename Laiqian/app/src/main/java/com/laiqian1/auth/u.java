package com.laiqian.auth;

import android.view.View;
import com.laiqian.member.bz;

class u implements View.OnFocusChangeListener {
  u(CreateEmployeeDialog paramCreateEmployeeDialog) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      bz bz;
      if ((bz = this.aDT.aDP).aE(CreateEmployeeDialog.b(this.aDT))) {
        this.aDT.aDP = bz.Qw();
        this.aDT.aDP.a(CreateEmployeeDialog.b(this.aDT), 500L, this.aDT.aDQ);
        this.aDT.aDP.start();
        return;
      } 
      if (this.aDT.aDP != null) {
        this.aDT.aDP.stop();
        return;
      } 
    } else if (this.aDT.aDP != null) {
      this.aDT.aDP.stop();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\aut\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */