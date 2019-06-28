package com.laiqian.dcb.api.server.c;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.dcb.api.b.d;
import com.laiqian.dcb.api.b.f;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.dcb.api.server.a;
import io.netty.channel.ae;
import io.netty.channel.n;
import io.netty.channel.z;
import io.reactivex.g.a;

public class a extends ae {
  private Context context;
  
  public a(Context paramContext) { this.context = paramContext; }
  
  public void a(z paramz) throws Exception {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramz.aDb().YV());
    stringBuilder.append("->Client open ");
    d.an(stringBuilder.toString());
    super.a(paramz);
  }
  
  public void a(z paramz, Object paramObject) throws Exception {
    (new c()).e(paramz, paramObject);
    super.a(paramz, paramObject);
  }
  
  public void a(z paramz, Throwable paramThrowable) throws Exception {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramz.aDb().YV());
    stringBuilder.append(" cause : ");
    stringBuilder.append(paramThrowable.toString());
    d.an(stringBuilder.toString());
  }
  
  public void b(z paramz) throws Exception {
    n n = paramz.aDb();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(n.YV());
    stringBuilder.append("->Client close ");
    d.an(stringBuilder.toString());
    paramz.Zb();
    if (ServerService.aPG != null)
      ServerService.aPG.remove(n); 
    super.b(paramz);
  }
  
  public void c(z paramz, Object paramObject) throws Exception { a.aKh().r(new b(this, paramz, paramObject)); }
  
  public void d(z paramz) throws Exception { paramz.aDj(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\server\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */