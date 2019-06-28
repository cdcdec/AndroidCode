package com.laiqian.dcb.api.server;

import com.laiqian.dcb.api.server.b.a;
import io.netty.c.a.a.aa;
import io.netty.c.a.a.aj;
import io.netty.c.d.c;
import io.netty.channel.ChannelHandler;
import io.netty.channel.af;
import io.netty.channel.aq;
import io.netty.channel.n;

class d extends af {
  d(ServerService paramServerService) {}
  
  protected void a(n paramn) throws Exception {
    aq aq = paramn.YY();
    aq.b(new ChannelHandler[] { new aj() });
    aq.b(new ChannelHandler[] { new aa(1048576) });
    aq.b(new ChannelHandler[] { new c() });
    aq.b(new ChannelHandler[] { new a() });
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\server\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */