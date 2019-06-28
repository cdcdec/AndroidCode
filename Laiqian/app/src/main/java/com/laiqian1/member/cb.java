package com.laiqian.member;

import com.squareup.moshi.Json;

public class cb {
  @Json(name = "filter")
  private String bwc;
  
  @Json(name = "orderBy")
  private String orderBy;
  
  public String Qy() { return this.bwc; }
  
  public String Qz() { return this.orderBy; }
  
  public void fC(String paramString) { this.bwc = paramString; }
  
  public void fD(String paramString) { this.orderBy = paramString; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */