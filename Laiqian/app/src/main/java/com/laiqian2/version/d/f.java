package com.laiqian.version.d;

import com.google.a.a.a.a.a.a;
import com.laiqian.i.d;
import com.laiqian.infrastructure.R;
import com.laiqian.network.h;
import com.laiqian.version.a.e.b;
import java.io.IOException;
import retrofit2.b;
import retrofit2.d;
import retrofit2.u;

class f extends Object implements d<h> {
  f(e parame) {}
  
  public void a(b<h> paramb, Throwable paramThrowable) { e.a(this.dJH).sq(e.b(this.dJH).getString(R.string.pos_upgrade_check_network)); }
  
  public void a(b<h> paramb, u<h> paramu) {
    try {
      b b1 = (b)d.b(((h)paramu.aZd()).oV(), b.class);
      if (b1.dIz == 0 && "reply success".equals(b1.message)) {
        e.a(this.dJH).axp();
        return;
      } 
      e.a(this.dJH).sq(e.b(this.dJH).getString(R.string.pos_upgrade_server_process_fail));
      return;
    } catch (IOException paramb) {
      a.e(paramb);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */