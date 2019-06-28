package com.laiqian.product.b;

import com.laiqian.b.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.f.b;
import com.laiqian.i.d;
import com.laiqian.network.b;
import com.laiqian.network.g;
import com.laiqian.network.h;
import com.laiqian.network.n;
import com.laiqian.pos.industry.b;
import com.laiqian.util.n;
import com.squareup.moshi.Json;
import java.io.IOException;

public class a extends a<a.a, a.b> {
  public b a(a parama) throws IOException {
    String str1 = String.valueOf(System.currentTimeMillis() / 1000L);
    String str2 = b.c(n.parseLong(str1), n.parseInt(RootApplication.getLaiqianPreferenceManager().Tx()));
    b b = (b)n.bUo.af(b.class);
    g g = new g(d.ac(parama));
    return (b)d.b(((h)b.a(b.crJ, g, RootApplication.getLaiqianPreferenceManager().Tx(), str1, str2).aYS().aZd()).oV(), b.class);
  }
  
  public static class a implements a.a {
    @Json(name = "nShopID")
    private final String aSI;
    
    @Json(name = "sUserPhone")
    private final String bfo;
    
    @Json(name = "nProductID")
    private final String cOt;
    
    @Json(name = "sUserPassword")
    private final String cVy;
    
    @Json(name = "nProductStatus")
    private final String cVz;
    
    public a(a param1a) {
      this.bfo = a.a(param1a);
      this.cVy = a.b(param1a);
      this.aSI = a.c(param1a);
      this.cOt = a.d(param1a);
      this.cVz = a.e(param1a);
    }
    
    public static class a {
      private String aSI;
      
      private String bfo;
      
      private String cOt;
      
      private String cVy;
      
      private String cVz;
      
      public a.a alk() { return new a.a(this); }
      
      public a cS(long param2Long) {
        this.cOt = String.valueOf(param2Long);
        return this;
      }
      
      public a cT(long param2Long) {
        this.cVz = String.valueOf(param2Long);
        return this;
      }
      
      public a mN(String param2String) {
        this.bfo = param2String;
        return this;
      }
      
      public a mO(String param2String) {
        this.cVy = param2String;
        return this;
      }
      
      public a mP(String param2String) {
        this.aSI = param2String;
        return this;
      }
    }
  }
  
  public static class a {
    private String aSI;
    
    private String bfo;
    
    private String cOt;
    
    private String cVy;
    
    private String cVz;
    
    public a.a alk() { return new a.a(this); }
    
    public a cS(long param1Long) {
      this.cOt = String.valueOf(param1Long);
      return this;
    }
    
    public a cT(long param1Long) {
      this.cVz = String.valueOf(param1Long);
      return this;
    }
    
    public a mN(String param1String) {
      this.bfo = param1String;
      return this;
    }
    
    public a mO(String param1String) {
      this.cVy = param1String;
      return this;
    }
    
    public a mP(String param1String) {
      this.aSI = param1String;
      return this;
    }
  }
  
  public static class b implements a.b {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */