package com.laiqian.auth;

import com.laiqian.basic.RootApplication;
import com.laiqian.sync.a.l;
import com.laiqian.sync.model.b;
import com.laiqian.util.logger.h;
import com.laiqian.util.p;
import io.reactivex.g.a;
import java.util.Map;

class bv implements l {
  bv(UserManagement paramUserManagement) {}
  
  public void onSuccess() {
    p.bO(this.aGm.getApplicationContext());
    b.a(RootApplication.getLaiqianPreferenceManager().Tx(), a.aKh()).b(bw.aEo).a(bx.aEp, by.aEp);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */