package com.laiqian.dcb.api.server.c;

import android.content.Context;
import com.laiqian.dcb.api.server.a;
import io.netty.c.a.b.a;
import io.netty.c.a.b.b;
import io.netty.c.a.y;
import io.netty.c.a.z;
import io.netty.c.e.c;
import io.netty.channel.af;
import io.netty.channel.aq;
import io.netty.channel.c.f;
import io.netty.channel.n;
import io.netty.e.g;
import java.util.concurrent.TimeUnit;

public class d extends af<f> {
  private Context context;
  
  public d(Context paramContext) { this.context = paramContext; }
  
  protected void a(f paramf) throws Exception {
    aq aq = paramf.YY();
    if ((new a()).Ds()) {
      aq.b("frameDecoder", new y(2147483647, false, 4, false, 4));
      aq.b("frameEncoder", new z(4));
    } 
    aq.b("decoder", new a(g.UTF_8));
    aq.b("encoder", new b(g.UTF_8));
    aq.b("timeout", new c(60L, 15L, 13L, TimeUnit.SECONDS));
    aq.b("handler", new a(this.context));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\server\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */