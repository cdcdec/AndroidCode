package com.laiqian.auth;

import android.view.View;
import com.laiqian.util.bb;

class m implements View.OnClickListener {
  m(AuthSetting paramAuthSetting) {}
  
  public void onClick(View paramView) {
    if (paramView.equals(AuthSetting.e(this.aDF))) {
      bb.ao("v.equals(selectedVeiw)");
      return;
    } 
    AuthSetting.b(this.aDF, paramView);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */