package com.laiqian.login.view;

import com.laiqian.basic.RootApplication;
import com.laiqian.sync.a.l;
import com.laiqian.sync.model.b;
import com.laiqian.util.logger.h;
import com.laiqian.util.p;
import io.reactivex.g.a;
import java.util.Map;

class an implements l {
  an(am paramam) {}
  
  public void onSuccess() {
    p.bO(this.aZZ.aZX.aZD.getApplicationContext());
    b.a(RootApplication.getLaiqianPreferenceManager().Tx(), a.aKh()).b(ao.aEo).a(ap.aEp, aq.aEp);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */