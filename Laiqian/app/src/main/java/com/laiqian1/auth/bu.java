package com.laiqian.auth;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class bu extends Handler {
  bu(UserManagement paramUserManagement) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 4:
        Toast.makeText(this.aGm, 2131628465, 0).show();
        return;
      case 3:
        Toast.makeText(this.aGm, 2131628468, 0).show();
        return;
      case 2:
        Toast.makeText(this.aGm, 2131628466, 0).show();
        return;
      case 1:
        break;
    } 
    UserManagement.c(this.aGm).dismiss();
    UserManagement.a(this.aGm, paramMessage.obj.toString());
    Toast.makeText(this.aGm, 2131628464, 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */