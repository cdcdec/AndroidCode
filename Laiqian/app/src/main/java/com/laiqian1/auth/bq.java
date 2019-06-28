package com.laiqian.auth;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.milestone.h;
import java.util.HashMap;

class bq extends Handler {
  bq(UserManagement paramUserManagement) {}
  
  public void handleMessage(Message paramMessage) {
    UserManagement.u(this.aGm).apy().gW(false);
    UserManagement.a(this.aGm, true);
    if (((Boolean)paramMessage.obj).booleanValue()) {
      if (UserManagement.t(this.aGm) != null && UserManagement.t(this.aGm).isShowing()) {
        if (UserManagement.v(this.aGm) != null)
          this.aGm.getSharedPreferences("settings", 0).edit().putString("user_password", UserManagement.v(this.aGm)).commit(); 
        UserManagement.t(this.aGm).dismiss();
      } 
      Toast.makeText(this.aGm, this.aGm.getString(2131629905), 0).show();
    } else {
      if (UserManagement.w(this.aGm) != null) {
        String str = (String)((HashMap)UserManagement.j(this.aGm).getTag()).get("_id");
        h h = new h(this.aGm);
        h.c(str, UserManagement.w(this.aGm));
        h.close();
        UserManagement.b(this.aGm, UserManagement.w(this.aGm));
      } 
      Toast.makeText(this.aGm, this.aGm.getString(2131629905), 0).show();
    } 
    UserManagement.h(this.aGm);
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */