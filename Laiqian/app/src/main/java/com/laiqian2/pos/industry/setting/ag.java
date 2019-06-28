package com.laiqian.pos.industry.setting;

import com.laiqian.basic.RootApplication;
import com.laiqian.sync.a.l;
import com.laiqian.sync.model.b;
import com.laiqian.util.logger.h;
import com.laiqian.util.p;
import io.reactivex.g.a;
import java.util.Map;

class ag implements l {
  ag(MainSetting paramMainSetting) {}
  
  public void onSuccess() {
    p.bO(this.csj.getApplicationContext());
    b.a(RootApplication.getLaiqianPreferenceManager().Tx(), a.aKh()).b(ah.aEo).a(ai.aEp, aj.aEp);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */