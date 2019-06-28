package com.laiqian.entity;

public class ai {
  private int aUH;
  
  private int aUI;
  
  private String aUJ;
  
  private String aUK;
  
  private ai(a parama) {
    this.aUH = a.a(parama);
    this.aUI = a.b(parama);
    this.aUJ = a.c(parama);
    this.aUK = a.d(parama);
  }
  
  public int HF() { return this.aUH; }
  
  public int HG() { return this.aUI; }
  
  public String HH() { return this.aUJ; }
  
  public String HI() { return this.aUK; }
  
  public static final class a {
    private int aUH;
    
    private int aUI;
    
    private String aUJ;
    
    private String aUK;
    
    public ai HJ() { return new ai(this, null); }
    
    public a dr(String param1String) {
      this.aUJ = param1String;
      return this;
    }
    
    public a ds(String param1String) {
      this.aUK = param1String;
      return this;
    }
    
    public a eD(int param1Int) {
      this.aUH = param1Int;
      return this;
    }
    
    public a eE(int param1Int) {
      this.aUI = param1Int;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */