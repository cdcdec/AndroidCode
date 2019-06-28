package com.laiqian.sync.view;

import com.laiqian.basic.RootApplication;
import com.laiqian.sync.a.l;
import com.laiqian.sync.model.b;
import com.laiqian.util.logger.h;
import com.laiqian.util.p;
import io.reactivex.g.a;
import java.util.Map;

class e implements l {
  e(SealData paramSealData) {}
  
  public void onSuccess() {
    p.bO(this.dpZ.getApplicationContext());
    b.a(RootApplication.getLaiqianPreferenceManager().Tx(), a.aKh()).b(f.aEo).a(g.aEp, h.aEp);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */