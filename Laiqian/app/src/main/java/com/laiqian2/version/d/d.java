package com.laiqian.version.d;

import com.google.a.a.a.a.a.a;
import com.laiqian.i.d;
import com.laiqian.infrastructure.R;
import com.laiqian.network.h;
import com.laiqian.version.a.d.b;
import com.laiqian.version.a.d.c;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.b;
import retrofit2.d;
import retrofit2.u;

class d extends Object implements d<h> {
  d(c paramc) {}
  
  public void a(b<h> paramb, Throwable paramThrowable) { c.a(this.dJF).sq(c.b(this.dJF).getString(R.string.pos_upgrade_check_network)); }
  
  public void a(b<h> paramb, u<h> paramu) {
    try {
      if ((new JSONObject(((h)paramu.aZd()).oV())).getInt("msg_no") == 0) {
        c c1 = ((b)d.b(((h)paramu.aZd()).oV(), b.class)).dIO;
        c.a(this.dJF).a(c1);
        return;
      } 
      c.a(this.dJF).axp();
      return;
    } catch (IOException paramb) {
      a.e(paramb);
      return;
    } catch (JSONException paramb) {
      a.e(paramb);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */