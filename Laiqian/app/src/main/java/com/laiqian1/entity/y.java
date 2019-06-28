package com.laiqian.entity;

import java.io.Serializable;

public class y implements Serializable {
  public final String aRu;
  
  public final int aRw;
  
  public final long aSW;
  
  public final String aTp;
  
  public final String aTq;
  
  public final String aTr;
  
  public final String aTs;
  
  public final String aTt;
  
  public final String address;
  
  public final String birthday;
  
  public final String name;
  
  public y(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9) {
    this.aSW = paramLong;
    this.name = paramString1;
    this.aTp = paramString2;
    this.aRw = paramInt;
    this.aRu = paramString3;
    this.address = paramString4;
    this.aTq = paramString5;
    this.aTr = paramString6;
    this.aTt = paramString9;
    this.birthday = c.cN(paramString8);
    this.aTs = paramString7;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */