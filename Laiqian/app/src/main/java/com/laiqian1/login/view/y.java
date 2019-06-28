package com.laiqian.login.view;

import android.app.Activity;
import android.content.Intent;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.a.b;
import com.laiqian.ui.a.r;

class y implements r.a {
  y(LoginActivity paramLoginActivity) {}
  
  public void xD() {}
  
  public void xE() {
    this.aZD.stopService(new Intent(this.aZD.getActivity(), com.laiqian.print.dualscreen.DualScreenService.class));
    for (Activity activity : RootApplication.aIV) {
      if (!activity.isDestroyed() || activity.isFinishing())
        activity.finish(); 
    } 
    b.aOw.Dk().close();
    this.aZD.finish();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */