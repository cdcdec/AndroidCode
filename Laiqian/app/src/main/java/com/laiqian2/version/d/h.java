package com.laiqian.version.d;

import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.i.d;
import com.laiqian.network.h;
import com.laiqian.util.ch;
import com.laiqian.version.a.f.b;
import com.laiqian.version.a.f.d;
import retrofit2.b;
import retrofit2.d;
import retrofit2.u;

class h extends Object implements d<h> {
  h(g paramg) {}
  
  public void a(b paramb, Throwable paramThrowable) { Log.w(this.dJL.TAG, "call to get VersionInfoResponse fail"); }
  
  public void a(b<h> paramb, u<h> paramu) {
    try {
      if (!paramu.aTa()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("request failed: ");
        stringBuilder.append(paramu.aGo());
        stringBuilder.append(" ");
        stringBuilder.append(paramu.message());
        throw new Exception(stringBuilder.toString());
      } 
      d d1 = (d)d.b(((h)paramu.aZd()).oV(), d.class);
      if (d1 != null) {
        StringBuilder stringBuilder;
        g g1;
        switch (d1.dIS.size()) {
          case 2:
            g1 = this.dJL;
            stringBuilder = new StringBuilder();
            stringBuilder.append(((b)d1.dIS.get(1)).version);
            stringBuilder.append("");
            g.a(g1, stringBuilder.toString());
          case 1:
            if (((b)d1.dIS.get(0)).version == ch.getVersionCode()) {
              g1 = this.dJL;
              stringBuilder = new StringBuilder();
              stringBuilder.append(((b)d1.dIS.get(0)).version);
              stringBuilder.append("");
              g.b(g1, stringBuilder.toString());
              break;
            } 
            g1 = this.dJL;
            stringBuilder = new StringBuilder();
            stringBuilder.append(((b)d1.dIS.get(0)).version);
            stringBuilder.append("");
            g.a(g1, stringBuilder.toString());
            break;
        } 
        g.b(this.dJL).a(d1, g.a(this.dJL));
        return;
      } 
      Log.w(this.dJL.TAG, "VersionInfoResponse is null");
      return;
    } catch (Exception paramb) {
      a.e(paramb);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */