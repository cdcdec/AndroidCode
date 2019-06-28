package com.laiqian.print;

import java.io.Serializable;

@Deprecated
public class bl implements Serializable {
  public static final bl cEa = new bl(false);
  
  public static final bl cEb = new bl(true);
  
  public static final bl cEc = new bl(2);
  
  public static final bl cEd = new bl(3);
  
  public static final bl cEe = new bl(4);
  
  private final int mUsage;
  
  private bl(int paramInt) { this.mUsage = paramInt; }
  
  public static bl hN(int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("unknown usage code: ");
        stringBuilder.append(paramInt);
        throw new IllegalArgumentException(stringBuilder.toString());
      case 4:
        return cEe;
      case 3:
        return cEd;
      case 2:
        return cEc;
      case 1:
        return cEb;
      case 0:
        break;
    } 
    return cEa;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = false;
    if (paramObject == null)
      return false; 
    if (paramObject == this)
      return true; 
    if (paramObject instanceof bl) {
      if (((bl)paramObject).mUsage == this.mUsage)
        bool = true; 
      return bool;
    } 
    return false;
  }
  
  public int getCode() { return this.mUsage; }
  
  public int hashCode() { return this.mUsage; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */