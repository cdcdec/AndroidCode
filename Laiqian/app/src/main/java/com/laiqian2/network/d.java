package com.laiqian.network;

import b.af;
import b.t;
import com.laiqian.dcb.api.b.a.b;
import com.laiqian.pos.industry.a;
import com.laiqian.util.bd;
import java.io.IOException;
import retrofit2.e;

class d extends Object implements e<g, af> {
  d(c paramc) {}
  
  public af a(g paramg) throws IOException {
    try {
      return (new t.a()).bO(bd.bVt, b.encode(paramg.oV())).bO("industry", a.crh).aRU();
    } catch (Exception paramg) {
      throw new IOException(paramg);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */