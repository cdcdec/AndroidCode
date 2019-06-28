package com.laiqian.auth;

import com.laiqian.ui.a.r;

class bs implements r.a {
  bs(UserManagement paramUserManagement, int paramInt) {}
  
  public void xD() {
    UserManagement.c(this.aGm, this.aGn);
    if (this.aGn >= 0) {
      UserManagement.f(this.aGm).getView(this.aGn, null, null).performClick();
      return;
    } 
    if (this.aGn == -1) {
      this.aGm.finish();
      return;
    } 
    if (this.aGn == -2)
      this.aGm.aFX.performClick(); 
  }
  
  public void xE() {
    UserManagement.c(this.aGm, this.aGn);
    UserManagement.x(this.aGm).performClick();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */