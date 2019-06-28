package com.laiqian.auth;

import com.laiqian.ui.a.r;
import java.util.HashMap;

class ca implements r.a {
  ca(bz parambz) {}
  
  public void xD() { UserManagement.d(this.aGo.aGm).dismiss(); }
  
  public void xE() {
    HashMap hashMap = (HashMap)UserManagement.f(this.aGo.aGm).getView(((Integer)(UserManagement.e(this.aGo.aGm)).object).intValue(), null, null).getTag();
    (new UserManagement.a(this.aGo.aGm, null)).execute(new String[] { ((String)hashMap.get("sUserPhone")).toString() });
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */