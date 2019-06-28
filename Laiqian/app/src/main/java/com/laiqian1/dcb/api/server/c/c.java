package com.laiqian.dcb.api.server.c;

import com.laiqian.dcb.api.b.d;
import com.laiqian.dcb.api.server.a;
import com.laiqian.dcb.api.server.a.c;
import io.netty.c.e.a;
import io.netty.c.e.b;
import io.netty.channel.z;

public class c {
  public void e(z paramz, Object paramObject) {
    if (paramObject instanceof b) {
      paramObject = (b)paramObject;
      if (paramObject.aGK().equals(a.emP)) {
        paramObject = new StringBuilder();
        paramObject.append(paramz.aDb().YV());
        paramObject.append("READER_IDLE");
        d.ao(paramObject.toString());
        return;
      } 
      if (paramObject.aGK().equals(a.emQ)) {
        paramObject = new StringBuilder();
        paramObject.append(paramz.aDb().YV());
        paramObject.append("WRITER_IDLE");
        d.ao(paramObject.toString());
        return;
      } 
      paramObject = new StringBuilder();
      paramObject.append(paramz.aDb().YV());
      paramObject.append("ALL_IDLE");
      d.ao(paramObject.toString());
      if (paramObject.aGK().equals(a.emR) && (new a()).DT())
        c.a(paramz.aDb(), 1004, 1, "", "", ""); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\server\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */