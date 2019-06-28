package com.laiqian.auth;

import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class bz implements w.a {
  bz(UserManagement paramUserManagement) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    if (paramInt == 0) {
      if (UserManagement.d(this.aGm) == null) {
        UserManagement.a(this.aGm, new r(this.aGm, new ca(this)));
        UserManagement.d(this.aGm).setTitle(this.aGm.getString(2131626281));
        UserManagement.d(this.aGm).s(this.aGm.getString(2131629774));
        UserManagement.d(this.aGm).t(this.aGm.getString(2131627735));
        UserManagement.d(this.aGm).oZ(this.aGm.getString(2131627732));
      } 
      UserManagement.d(this.aGm).show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */