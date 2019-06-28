package com.laiqian.login.b;

import android.content.Context;
import com.laiqian.i.d;
import com.laiqian.network.j;
import com.laiqian.pos.hardware.q;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import io.reactivex.b.a;
import retrofit2.a.a.a;
import retrofit2.b;
import retrofit2.u;
import retrofit2.v;

public class f {
  private static final String aYQ;
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckC);
    stringBuilder.append("device/add");
    aYQ = stringBuilder.toString();
  }
  
  public void au(Context paramContext) throws Exception {
    null = (a)(new v.a()).a(j.adg).vX("http://interface.91laiqian.com").a(a.b(d.aXE)).aZh().af(a.class);
    b b = d.ak(paramContext);
    b1 = null.a(aYQ, b);
    a = null;
    try {
      u u = b1.aYS();
      if (!u.aTa())
        throw new Exception(u.toString()); 
      u = null;
    } catch (Exception b1) {}
    b b2 = null.a("https://platformapi-erp.meituan.com/api/v1/multibrand/merchant/sn?clientId=d97f0c68cccadaf71376df56b6b8c8b5", b);
    try {
      u u = b2.aYS();
      if (!u.aTa())
        throw new Exception(u.toString()); 
    } catch (Exception a) {}
    if (b1 != null || a != null) {
      a a1;
      if (b1 != null && a != null) {
        a1 = new a(new Throwable[] { b1, a });
      } else if (a1 == null) {
        a1 = a;
      } 
      h.a(new d(getClass().getName(), "execute", "Exception", a1.toString()), h.a.dHw, h.b.dHF);
      throw a1;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */