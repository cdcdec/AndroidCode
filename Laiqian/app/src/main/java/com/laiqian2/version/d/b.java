package com.laiqian.version.d;

import com.google.a.a.a.a.a.a;
import com.laiqian.i.d;
import com.laiqian.infrastructure.R;
import com.laiqian.network.h;
import com.laiqian.version.a.a.b;
import java.io.IOException;
import retrofit2.b;
import retrofit2.d;
import retrofit2.u;

class b extends Object implements d<h> {
  b(a parama) {}
  
  public void a(b<h> paramb, Throwable paramThrowable) { a.a(this.dJD).sq(a.b(this.dJD).getString(R.string.pos_upgrade_check_network)); }
  
  public void a(b<h> paramb, u<h> paramu) {
    try {
      if (((b)d.b(((h)paramu.aZd()).oV(), b.class)).dIz == 0) {
        a.a(this.dJD).axm();
        return;
      } 
      a.a(this.dJD).sq(a.b(this.dJD).getString(R.string.pos_upgrade_server_process_fail));
      return;
    } catch (IOException paramb) {
      a.e(paramb);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */