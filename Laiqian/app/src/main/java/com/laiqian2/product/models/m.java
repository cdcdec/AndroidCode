package com.laiqian.product.models;

import com.laiqian.util.n;

public class m {
  public final long aSW;
  
  private long bTQ;
  
  private String bTS;
  
  private double cVh;
  
  private String cVi;
  
  private double cVj;
  
  private String cVk;
  
  public final double cVl;
  
  public double cVm;
  
  private String name;
  
  public m(long paramLong1, String paramString1, double paramDouble1, double paramDouble2, long paramLong2, String paramString2) { this(paramLong1, paramString1, paramDouble1, paramDouble2, paramLong2, paramString2, 1.0D); }
  
  public m(long paramLong1, String paramString1, double paramDouble1, double paramDouble2, long paramLong2, String paramString2, double paramDouble3) {
    this.aSW = paramLong1;
    this.name = paramString1;
    this.cVh = paramDouble1;
    this.cVi = n.b(null, Double.valueOf(paramDouble1), false, true);
    this.cVj = paramDouble2;
    this.cVk = n.b(null, Double.valueOf(paramDouble2), false, true);
    this.bTQ = paramLong2;
    this.bTS = paramString2;
    this.cVl = paramDouble3;
  }
  
  public long Ww() { return this.bTQ; }
  
  public String Wy() { return this.bTS; }
  
  public double akU() { return this.cVh; }
  
  public String akV() { return this.cVi; }
  
  public double akW() { return this.cVj; }
  
  public String akX() { return this.cVk; }
  
  public boolean akY() { return (akU() <= akW()); }
  
  public String getName() { return this.name; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */