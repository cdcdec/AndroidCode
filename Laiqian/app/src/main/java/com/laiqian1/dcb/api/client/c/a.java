package com.laiqian.dcb.api.client.c;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.dcb.api.a.a;
import com.laiqian.dcb.api.b.d;
import com.laiqian.dcb.api.b.f;
import com.laiqian.dcb.api.b.g;
import com.laiqian.dcb.api.b.h;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.client.a.a;
import com.laiqian.dcb.api.client.b;
import com.laiqian.dcb.api.client.b.a;
import com.laiqian.dcb.api.client.k;
import io.netty.c.e.a;
import io.netty.c.e.b;
import io.netty.channel.co;
import io.netty.channel.n;
import io.netty.channel.z;
import io.netty.e.p;
import io.reactivex.g.a;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a extends co {
  private n aPd;
  
  public boolean aPo;
  
  Context context;
  
  public a(Context paramContext) { this.context = paramContext; }
  
  public n DN() { return this.aPd; }
  
  public void a(z paramz) throws Exception {
    k.aPi = 1;
    g g = new g(this.context);
    g.X(System.currentTimeMillis());
    g.ct(true);
    g.close();
    b(paramz.aDb());
    d.e("_client", "Connected server");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_clientConnected server");
    stringBuilder.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS")).format(new Date()));
    h.cF(stringBuilder.toString());
    a.cz(a.a(this.context, 1003, ""));
    if (!a.aPm)
      a.cz(a.a(this.context, 3001, "")); 
    a.a(this.context, new int[] { 2001, 2004 }, 1005, 1, "");
    super.a(paramz);
  }
  
  public void a(z paramz, Object paramObject) throws Exception {
    if (paramObject instanceof b) {
      Object object = null;
      paramObject = (b)paramObject;
      if (paramObject.aGK().equals(a.emP)) {
        paramObject = "服务端读超时";
      } else if (paramObject.aGK().equals(a.emQ)) {
        paramObject = object;
      } else {
        paramObject.aGK().equals(a.emR);
        paramObject = object;
      } 
      if (paramObject != null) {
        object = new StringBuilder();
        object.append(paramz.aDb().YV());
        object.append(paramObject);
        d.ao(object.toString());
      } 
    } 
  }
  
  public void a(z paramz, Throwable paramThrowable) throws Exception {
    k.aPi = 0;
    if (!paramz.aDb().isActive())
      d.e("_client", "Client close "); 
    a.e(paramThrowable);
    paramz.Zb();
    a.a(this.context, new int[] { 2001, 2004 }, 1005, 0, "");
  }
  
  public void b(n paramn) { this.aPd = paramn; }
  
  public void b(z paramz) throws Exception {
    d.e("_client", "Client close ");
    if (!this.aPo) {
      g g = new g(this.context);
      g.X(System.currentTimeMillis());
      g.close();
      k.aPi = 0;
      a.a(this.context, new int[] { 2001, 2004 }, 1005, 0, "");
    } else {
      this.aPo = false;
    } 
    super.b(paramz);
  }
  
  protected void b(z paramz, Object paramObject) throws Exception {
    String str = paramObject.toString();
    p.release(paramObject);
    a.aKh().r(new b(this, str));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\client\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */