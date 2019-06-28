package com.laiqian.pos;

import com.laiqian.basic.RootApplication;
import com.laiqian.sync.a.l;
import com.laiqian.sync.model.b;
import com.laiqian.util.logger.h;
import com.laiqian.util.p;
import io.reactivex.g.a;
import java.util.Map;

class az implements l {
  az(PosDownloaderAfterLogin paramPosDownloaderAfterLogin) {}
  
  public void onSuccess() {
    p.bO(this.cgy.getApplicationContext());
    b.a(RootApplication.getLaiqianPreferenceManager().Tx(), a.aKh()).b(ba.aEo).a(bb.aEp, bc.aEp);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */