package com.laiqian.entity;

import com.laiqian.product.models.h;
import com.laiqian.ui.a.g;

public class al implements g.b {
  public double aUz;
  
  public h aVi;
  
  private al(a parama) {
    this.aUz = a.a(parama);
    this.aVi = a.b(parama);
  }
  
  public long AR() { return this.aVi.getID(); }
  
  public CharSequence AS() { return this.aVi.getName(); }
  
  public CharSequence AT() { return this.aVi.getName(); }
  
  public static final class a {
    private double aUz;
    
    private h aVi;
    
    public al Ih() { return new al(this, null); }
    
    public a U(double param1Double) {
      this.aUz = param1Double;
      return this;
    }
    
    public a a(h param1h) {
      this.aVi = param1h;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */