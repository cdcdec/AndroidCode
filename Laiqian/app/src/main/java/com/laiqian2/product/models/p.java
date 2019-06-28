package com.laiqian.product.models;

import android.support.annotation.Keep;

@Keep
public class p {
  private String aWl;
  
  private long cVt;
  
  private double cVu;
  
  private double cVv;
  
  private double cVw;
  
  private double cVx;
  
  public p(long paramLong, String paramString, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    this.cVt = paramLong;
    this.aWl = paramString;
    this.cVu = paramDouble1;
    this.cVv = paramDouble2;
    this.cVw = paramDouble3;
    this.cVx = paramDouble4;
  }
  
  public String IT() { return this.aWl; }
  
  public void a(double paramDouble1, double paramDouble2, double paramDouble3) {
    this.cVv += paramDouble1;
    this.cVw += paramDouble2;
    this.cVx += paramDouble3;
  }
  
  public long alf() { return this.cVt; }
  
  public double alg() { return this.cVu; }
  
  public double alh() { return this.cVv; }
  
  public double ali() { return this.cVw; }
  
  public double alj() { return this.cVx; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */