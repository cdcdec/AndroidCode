package com.laiqian.entity;

import com.laiqian.main.bb;

public class q {
  private String aSr;
  
  private long aSu;
  
  private bb aSx;
  
  private String orderNo;
  
  private long time;
  
  private q() {}
  
  private q(a parama) {
    this.orderNo = a.a(parama);
    this.aSr = a.b(parama);
    this.aSu = a.c(parama);
    this.time = a.d(parama);
    this.aSx = a.e(parama);
  }
  
  public String Fl() { return this.aSr; }
  
  public long Fo() { return this.aSu; }
  
  public bb Fp() { return this.aSx; }
  
  public long getTime() { return this.time; }
  
  public String xq() { return this.orderNo; }
  
  public static class a {
    private String aSr;
    
    private long aSu;
    
    private bb aSx;
    
    private String orderNo;
    
    private long time;
    
    public q Fy() { return new q(this, null); }
    
    public a aj(long param1Long) {
      this.aSu = param1Long;
      return this;
    }
    
    public a ak(long param1Long) {
      this.time = param1Long;
      return this;
    }
    
    public a b(bb param1bb) {
      this.aSx = param1bb;
      return this;
    }
    
    public a df(String param1String) {
      this.orderNo = param1String;
      return this;
    }
    
    public a dg(String param1String) {
      this.aSr = param1String;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */