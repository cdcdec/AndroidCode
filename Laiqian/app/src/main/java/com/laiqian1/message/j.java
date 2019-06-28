package com.laiqian.message;

import android.text.TextUtils;

public class j {
  public static j bIw;
  
  public final String bIA;
  
  public final String bIB;
  
  public final String bIC;
  
  public final String bID;
  
  public final String bIE;
  
  public final String bIF;
  
  public final String bIG;
  
  public final String bIx;
  
  public final String bIy;
  
  public final String bIz;
  
  static  {
  
  }
  
  public j(a parama) {
    if (TextUtils.isEmpty(a.a(parama)))
      throw new IllegalArgumentException("online sync queue name not set"); 
    this.bIx = a.a(parama);
    if (TextUtils.isEmpty(a.b(parama)))
      throw new IllegalArgumentException("login queue name not set"); 
    this.bIB = a.b(parama);
    if (TextUtils.isEmpty(a.c(parama)))
      throw new IllegalArgumentException("sync queue name not set"); 
    this.bIC = a.c(parama);
    if (TextUtils.isEmpty(a.d(parama)))
      throw new IllegalArgumentException("order queue name not set"); 
    this.bIy = a.d(parama);
    if (TextUtils.isEmpty(a.e(parama)))
      throw new IllegalArgumentException("notification queue name not set"); 
    this.bIz = a.e(parama);
    if (TextUtils.isEmpty(a.f(parama)))
      throw new IllegalArgumentException("payCheck queue name not set"); 
    this.bIA = a.f(parama);
    if (TextUtils.isEmpty(a.g(parama)))
      throw new IllegalArgumentException("oss endpoint not set"); 
    this.bID = a.g(parama);
    if (TextUtils.isEmpty(a.h(parama)))
      throw new IllegalArgumentException("mns endpoint not set"); 
    this.bIF = a.h(parama);
    if (TextUtils.isEmpty(a.i(parama)))
      throw new IllegalArgumentException("oss bucket not set"); 
    this.bIE = a.i(parama);
    if (TextUtils.isEmpty(a.j(parama)))
      throw new IllegalArgumentException("register device url not set"); 
    this.bIG = a.j(parama);
  }
  
  public static class a {
    private String bIH;
    
    private String bII;
    
    private String bIJ;
    
    private String bIK;
    
    private String bIL;
    
    private String bIM;
    
    private String bIN;
    
    private String bIO;
    
    private String bIP;
    
    private String bIQ;
    
    public j Tq() { return new j(this); }
    
    public a gA(String param1String) {
      this.bIQ = param1String;
      return this;
    }
    
    public a gr(String param1String) {
      this.bIH = param1String;
      return this;
    }
    
    public a gs(String param1String) {
      this.bIK = param1String;
      return this;
    }
    
    public a gt(String param1String) {
      this.bII = param1String;
      return this;
    }
    
    public a gu(String param1String) {
      this.bIJ = param1String;
      return this;
    }
    
    public a gv(String param1String) {
      this.bIL = param1String;
      return this;
    }
    
    public a gw(String param1String) {
      this.bIM = param1String;
      return this;
    }
    
    public a gx(String param1String) {
      this.bIN = param1String;
      return this;
    }
    
    public a gy(String param1String) {
      this.bIO = param1String;
      return this;
    }
    
    public a gz(String param1String) {
      this.bIP = param1String;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */