package com.laiqian.auth;

import android.view.View;
import com.laiqian.ui.a.w;

class cd implements View.OnClickListener {
  cd(UserManagement paramUserManagement) {}
  
  public void onClick(View paramView) {
    byte b2;
    if (!UserManagement.a(this.aGm))
      return; 
    byte b3 = -1;
    if (UserManagement.p(this.aGm) == null)
      UserManagement.q(this.aGm); 
    if (UserManagement.p(this.aGm).length == 1)
      return; 
    String str = UserManagement.o(this.aGm).getText().toString().trim();
    byte b1 = 0;
    while (true) {
      b2 = b3;
      if (b1 < UserManagement.p(this.aGm).length) {
        if (str.equals(UserManagement.p(this.aGm)[b1])) {
          b2 = b1;
          break;
        } 
        b1++;
        continue;
      } 
      break;
    } 
    this.aGm.aGh = b2;
    if (UserManagement.r(this.aGm) == null) {
      UserManagement.a(this.aGm, new w(this.aGm, UserManagement.p(this.aGm), new ce(this)));
      UserManagement.r(this.aGm).setTitle(this.aGm.getString(2131626477));
    } 
    UserManagement.r(this.aGm).gn(this.aGm.aGh);
    UserManagement.r(this.aGm).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */