package com.laiqian.auth;

import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.n;
import java.util.HashMap;

class cc implements View.OnClickListener {
  cc(UserManagement paramUserManagement) {}
  
  public void onClick(View paramView) {
    try {
      String str1 = UserManagement.l(this.aGm).getText().toString().trim();
      if (str1.contains("'")) {
        n.w(this.aGm.getApplicationContext(), 2131627554);
        return;
      } 
      String str2 = (String)((HashMap)UserManagement.j(this.aGm).getTag()).get("_id");
      HashMap hashMap = new HashMap();
      hashMap.put("sUserName", str1);
      if (UserManagement.m(this.aGm).getVisibility() == 0) {
        if (UserManagement.n(this.aGm).isChecked()) {
          str1 = "170002";
        } else {
          str1 = "170001";
        } 
        hashMap.put("nDeletionFlag", str1);
      } 
      str1 = (String)UserManagement.o(this.aGm).getTag();
      if (UserManagement.o(this.aGm).isEnabled())
        hashMap.put("nUserRole", str1); 
      if (!this.aGm.save(str2, hashMap)) {
        UserManagement.a(this.aGm, false);
        return;
      } 
    } catch (Exception paramView) {
      a.e(paramView);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */