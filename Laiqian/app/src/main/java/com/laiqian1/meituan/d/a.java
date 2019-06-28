package com.laiqian.meituan.d;

public class a {
  private String bsp;
  
  private String bsq;
  
  private String bsr;
  
  public a(String paramString1, String paramString2, String paramString3) {
    fs(paramString1);
    ft(paramString2);
    fr(paramString3);
  }
  
  public String PK() { return this.bsr; }
  
  public String PL() { return this.bsp; }
  
  public String PM() { return this.bsq; }
  
  public void fr(String paramString) { this.bsr = paramString; }
  
  public void fs(String paramString) { this.bsp = paramString; }
  
  public void ft(String paramString) { this.bsq = paramString; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */