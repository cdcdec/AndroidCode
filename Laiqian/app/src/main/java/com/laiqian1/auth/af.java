package com.laiqian.auth;

import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.c;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

class af implements View.OnClickListener {
  af(ModifyUserPasswordDialog paramModifyUserPasswordDialog) {}
  
  public void onClick(View paramView) {
    ModifyUserPasswordDialog.e(this.aEe).setText("");
    if (ModifyUserPasswordDialog.f(this.aEe)) {
      String str = ModifyUserPasswordDialog.b(this.aEe).getText().toString().trim();
      try {
        String str1 = c.cI(str);
        str = str1;
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        a.e(noSuchAlgorithmException);
      } 
      HashMap hashMap = new HashMap();
      hashMap.put("sUserPassword", str);
      ModifyUserPasswordDialog.h(this.aEe).save(ModifyUserPasswordDialog.g(this.aEe), hashMap);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */