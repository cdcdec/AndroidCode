package com.laiqian.models;

import java.io.Serializable;

public class bf implements Serializable {
  private long bTQ;
  
  private double bTR;
  
  private String bTS;
  
  public bf() {}
  
  public bf(double paramDouble, String paramString, long paramLong) {
    this.bTR = paramDouble;
    this.bTS = paramString;
    this.bTQ = paramLong;
  }
  
  public long Ww() { return this.bTQ; }
  
  public double Wx() { return this.bTR; }
  
  public String Wy() { return this.bTS; }
  
  public void aw(double paramDouble) { this.bTR = paramDouble; }
  
  public void bR(long paramLong) { this.bTQ = paramLong; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (bf)paramObject;
      return (Double.compare(paramObject.bTR, this.bTR) != 0) ? false : this.bTS.equals(paramObject.bTS);
    } 
    return false;
  }
  
  public int hashCode() {
    long l = Double.doubleToLongBits(this.bTR);
    return (int)(l ^ l >>> 32) * 31 + this.bTS.hashCode();
  }
  
  public void iz(String paramString) { this.bTS = paramString; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UnitWeightEntity{unitWeight=");
    stringBuilder.append(this.bTR);
    stringBuilder.append(", unitName=");
    stringBuilder.append(this.bTS);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */