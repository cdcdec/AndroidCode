package com.laiqian.models;

import android.content.Context;
import c.n;
import com.google.a.a.a.a.a.a;
import com.laiqian.i.d;
import com.squareup.moshi.aa;
import hugo.weaving.DebugLog;
import java.io.IOException;
import java.util.LinkedHashMap;

public class h {
  private static boolean DEBUG = true;
  
  static h bOi;
  
  b bOj;
  
  Context mContext;
  
  static  {
  
  }
  
  private h(Context paramContext) {
    this.mContext = paramContext;
    UI();
  }
  
  @DebugLog
  private boolean UI() {
    try {
      iOException = this.mContext.getAssets().open("area.json");
    } catch (IOException iOException) {
      a.e(iOException);
      iOException = null;
    } 
    if (iOException == null)
      return false; 
    aa = aa.b(n.c(n.v(iOException)));
    try {
      this.bOj = (b)d.a(aa, b.class);
      return true;
    } catch (IOException aa) {
      a.e(aa);
      return false;
    } 
  }
  
  public static h aM(Context paramContext) {
    if (bOi == null)
      bOi = new h(paramContext.getApplicationContext()); 
    return bOi;
  }
  
  public b UJ() { return this.bOj; }
  
  public static class a {
    String bOk;
    
    LinkedHashMap<String, h.c> bOl = new LinkedHashMap();
    
    h.d bOm;
    
    h.e bOn;
    
    String name;
    
    public a(String param1String1, String param1String2, h.d param1d) {
      this.name = param1String1;
      this.bOk = param1String2;
      this.bOm = param1d;
    }
    
    public LinkedHashMap<String, h.c> UK() { return this.bOl; }
    
    public h.d UL() { return this.bOm; }
    
    void a(h.c param1c) { this.bOl.put(param1c.getName(), param1c); }
    
    void a(h.e param1e) { this.bOn = param1e; }
    
    public String getName() { return this.name; }
    
    public String getSimpleName() { return this.bOk; }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.bOk);
      stringBuilder.append(": ");
      stringBuilder.append(this.bOm.toString());
      stringBuilder.append(" ");
      stringBuilder.append(this.bOl.toString());
      return stringBuilder.toString();
    }
    
    class a {}
  }
  
  class h {}
  
  public static class b {
    h.e bOo;
    
    LinkedHashMap<String, h.e> bOp = new LinkedHashMap();
    
    String name;
    
    public b(String param1String) { this.name = param1String; }
    
    public LinkedHashMap<String, h.e> UM() { return this.bOp; }
    
    void b(h.e param1e) {
      if (param1e == null)
        return; 
      this.bOp.put(param1e.getName(), param1e);
    }
    
    void c(h.e param1e) {
      if (param1e != null)
        this.bOo = param1e; 
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.name);
      stringBuilder.append(": ");
      stringBuilder.append(this.bOp.toString());
      return stringBuilder.toString();
    }
    
    class b {}
  }
  
  class h {}
  
  public static class c {
    String bOk;
    
    h.d bOm;
    
    h.a bOq;
    
    String name;
    
    public c(String param1String1, String param1String2, h.d param1d) {
      this.name = param1String1;
      this.bOk = param1String2;
      this.bOm = param1d;
    }
    
    void a(h.a param1a) { this.bOq = param1a; }
    
    public String getName() { return this.name; }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.bOk);
      stringBuilder.append(": ");
      stringBuilder.append(this.bOm.toString());
      return stringBuilder.toString();
    }
    
    class c {}
  }
  
  class h {}
  
  public static class d {
    double bOr;
    
    double latitude;
    
    public d(String param1String) {
      if (param1String == null || "".equals(param1String))
        throw new IllegalArgumentException(); 
      String[] arrayOfString = param1String.split(",");
      this.latitude = Double.parseDouble(arrayOfString[0]);
      this.bOr = Double.parseDouble(arrayOfString[1]);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("{");
      stringBuilder.append(this.latitude);
      stringBuilder.append(",");
      stringBuilder.append(this.bOr);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
  }
  
  public static class e {
    String bOk;
    
    h.a bOs;
    
    LinkedHashMap<String, h.a> bOt = new LinkedHashMap();
    
    h.b bOu;
    
    String name;
    
    public e(String param1String1, String param1String2) {
      this.name = param1String1;
      this.bOk = param1String2;
    }
    
    public h.a UN() { return this.bOs; }
    
    public LinkedHashMap<String, h.a> UO() { return this.bOt; }
    
    void a(h.b param1b) { this.bOu = param1b; }
    
    void b(h.a param1a) { this.bOt.put(param1a.getName(), param1a); }
    
    void c(h.a param1a) { this.bOs = param1a; }
    
    public String getName() { return this.name; }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.bOk);
      stringBuilder.append(": ");
      stringBuilder.append(this.bOt.toString());
      return stringBuilder.toString();
    }
    
    class e {}
  }
  
  class h {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */