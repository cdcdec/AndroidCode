package com.laiqian.auth;

import android.view.View;
import java.util.HashMap;

class cf implements View.OnClickListener {
  cf(UserManagement paramUserManagement) {}
  
  public void onClick(View paramView) {
    if (!UserManagement.a(this.aGm))
      return; 
    if (UserManagement.t(this.aGm) == null) {
      UserManagement.a(this.aGm, new ModifyUserPasswordDialog(this.aGm));
      UserManagement.t(this.aGm).a(this.aGm);
    } 
    if (UserManagement.j(this.aGm) != null) {
      HashMap hashMap = (HashMap)UserManagement.j(this.aGm).getTag();
      UserManagement.t(this.aGm).w((String)hashMap.get("_id"), (String)hashMap.get("sUserPassword"));
    } 
    UserManagement.t(this.aGm).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */