package com.laiqian.dcb.api.server.a;

import com.laiqian.dcb.api.b.d;
import com.laiqian.dcb.api.server.ServerService;
import io.netty.channel.a.h;
import io.netty.channel.n;
import io.netty.e.b.aa;
import io.netty.e.c;
import io.netty.e.d;

public class a {
  public static final d<Integer> aPJ;
  
  public static final d<String> aPK;
  
  public static final d<String> aPL;
  
  public static final d<String> aPM = (aPL = (aPK = (aPJ = d.tM("counter")).tM("sUidKey")).tM("imei")).tM("sDevice");
  
  public boolean a(n paramn, String paramString1, String paramString2, String paramString3) {
    c c1 = paramn.a(aPJ);
    c c2 = paramn.a(aPK);
    c c3 = paramn.a(aPL);
    c c4 = paramn.a(aPM);
    Object object = c1.get();
    int i = 1;
    byte b = 0;
    int j = 0;
    if (object == null) {
      if (ServerService.aPG == null)
        ServerService.aPG = new h(aa.epF); 
      for (n n1 : ServerService.aPG) {
        if (((String)n1.a(aPK).get()).equals(paramString1)) {
          ServerService.aPG.remove(n1);
          c.a(n1, 1001, 2, "", "", "", new b(this));
          j = 1;
        } 
      } 
      c1.set(Integer.valueOf(1));
      c2.set(paramString1);
      c3.set(paramString3);
      c4.set(paramString2);
      ServerService.aPG.add(paramn);
    } else {
      i = 1 + ((Integer)c1.get()).intValue();
      c1.set(Integer.valueOf(i));
      j = b;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("第");
    stringBuilder.append(i);
    stringBuilder.append("次请求:当前共有");
    stringBuilder.append(ServerService.aPG.size());
    stringBuilder.append("个连接");
    d.an(stringBuilder.toString());
    return j;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\server\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */