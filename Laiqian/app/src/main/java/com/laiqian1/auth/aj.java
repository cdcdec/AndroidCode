package com.laiqian.auth;

import android.annotation.SuppressLint;
import com.laiqian.basic.RootApplication;
import com.laiqian.sync.a.l;
import com.laiqian.sync.model.b;
import com.laiqian.util.logger.h;
import com.laiqian.util.p;
import io.reactivex.g.a;
import java.util.Map;

class aj implements l {
  aj(PrivilegeLimitActivity paramPrivilegeLimitActivity) {}
  
  @SuppressLint({"CheckResult"})
  public void onSuccess() {
    p.bO(this.aEm.getApplicationContext());
    b.a(RootApplication.getLaiqianPreferenceManager().Tx(), a.aKh()).b(ak.aEo).a(al.aEp, am.aEp);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */