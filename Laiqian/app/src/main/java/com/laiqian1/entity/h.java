package com.laiqian.entity;

import java.util.ArrayList;

public class h {
  public double aSc;
  
  public double aSd;
  
  public double aSe;
  
  public int aSf;
  
  public double aSg;
  
  public ArrayList<al> aSh;
  
  public String id;
  
  public h() {}
  
  private h(a parama) {
    this.aSc = a.a(parama);
    this.aSd = a.b(parama);
    this.aSe = a.c(parama);
    this.aSf = a.d(parama);
    this.id = a.e(parama);
    this.aSg = a.f(parama);
    this.aSh = a.g(parama);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (h)paramObject;
      return (this.id != null) ? this.id.equals(paramObject.id) : ((paramObject.id == null) ? 1 : 0);
    } 
    return false;
  }
  
  public int hashCode() { return (this.id != null) ? this.id.hashCode() : 0; }
  
  public static final class a {
    private double aSc;
    
    private double aSd;
    
    private double aSe;
    
    private int aSf;
    
    private double aSg;
    
    private ArrayList<al> aSh;
    
    private String id;
    
    public h EX() { return new h(this, null); }
    
    public a cX(String param1String) {
      this.id = param1String;
      return this;
    }
    
    public a h(ArrayList<al> param1ArrayList) {
      this.aSh = param1ArrayList;
      return this;
    }
    
    public a l(double param1Double) {
      this.aSc = param1Double;
      return this;
    }
    
    public a m(double param1Double) {
      this.aSd = param1Double;
      return this;
    }
    
    public a n(double param1Double) {
      this.aSe = param1Double;
      return this;
    }
    
    public a o(double param1Double) {
      this.aSg = param1Double;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */