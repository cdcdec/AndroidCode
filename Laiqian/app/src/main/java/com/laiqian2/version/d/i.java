package com.laiqian.version.d;

import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.network.h;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.b;
import retrofit2.d;
import retrofit2.u;

class i extends Object implements d<h> {
  private boolean dJM = this.dJN.booleanValue();
  
  i(g paramg, Boolean paramBoolean) {}
  
  public void a(b<h> paramb, Throwable paramThrowable) { g.b(this.dJL).sq(g.c(this.dJL).getString(R.string.pos_upgrade_check_network)); }
  
  public void a(b<h> paramb, u<h> paramu) {
    if (paramu != null)
      try {
        if (paramu.aZd() != null && ((h)paramu.aZd()).oV() != null) {
          int j = (new JSONObject(((h)paramu.aZd()).oV())).getInt("msg_no");
          if (j == 0) {
            if (this.dJM) {
              g.b(this.dJL).axs();
              return;
            } 
            g.b(this.dJL).axq();
            return;
          } 
          if (j == -6) {
            if (this.dJM) {
              g.b(this.dJL).axt();
              return;
            } 
            g.b(this.dJL).axr();
            return;
          } 
          g.b(this.dJL).sq(g.c(this.dJL).getString(R.string.pos_upgrade_server_process_fail));
          return;
        } 
        g.b(this.dJL).sq(g.c(this.dJL).getString(R.string.pos_upgrade_server_process_fail));
        return;
      } catch (JSONException paramb) {
        a.e(paramb);
        return;
      }  
    g.b(this.dJL).sq(g.c(this.dJL).getString(R.string.pos_upgrade_server_process_fail));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */