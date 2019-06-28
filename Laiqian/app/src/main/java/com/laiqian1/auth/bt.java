package com.laiqian.auth;

import android.view.View;
import android.widget.Toast;
import com.laiqian.util.bd;

class bt implements View.OnClickListener {
  bt(UserManagement paramUserManagement) {}
  
  public void onClick(View paramView) {
    if (!bd.bH(this.aGm)) {
      Toast.makeText(this.aGm, this.aGm.getString(2131628423), 0).show();
      return;
    } 
    UserManagement.b(this.aGm);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */