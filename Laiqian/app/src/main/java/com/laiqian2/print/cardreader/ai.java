package com.laiqian.print.cardreader;

import java.io.Serializable;

public class ai implements Serializable {
  public static final ai cEP = new ai(false);
  
  public static final ai cEQ = new ai(true);
  
  public static final ai cER = new ai(2);
  
  private final int mUsage;
  
  private ai(int paramInt) { this.mUsage = paramInt; }
  
  public static ai hU(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 2:
        return cER;
      case 1:
        return cEQ;
      case 0:
        break;
    } 
    return cEP;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = false;
    if (paramObject == null)
      return false; 
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ai) {
      if (((ai)paramObject).mUsage == this.mUsage)
        bool = true; 
      return bool;
    } 
    return false;
  }
  
  public int getCode() { return this.mUsage; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */