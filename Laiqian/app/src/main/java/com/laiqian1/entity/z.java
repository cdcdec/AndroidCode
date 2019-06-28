package com.laiqian.entity;

import android.support.annotation.Keep;

@Keep
public class z {
  public double aJW;
  
  public int aTa;
  
  public double aTu;
  
  public final int aTv;
  
  public double aTw;
  
  public long aTx;
  
  public String aTy;
  
  public double discount;
  
  public final String name;
  
  public z(int paramInt, double paramDouble, String paramString, long paramLong) {
    this.aTv = paramInt;
    this.aJW = paramDouble;
    this.name = paramString;
    this.aTx = paramLong;
  }
  
  public z(z paramz, double paramDouble) { this(paramz.aTv, paramDouble, paramz.name, paramz.aTx); }
  
  public boolean equals(Object paramObject) {
    byte b = 0;
    if (paramObject == null)
      return false; 
    if (paramObject instanceof z) {
      paramObject = (z)paramObject;
      int i = b;
      if (this.aTv == paramObject.aTv) {
        if (10013 == this.aTv || 10007 == this.aTv || 10009 == this.aTv) {
          i = b;
          return (this.aTx == paramObject.aTx) ? true : i;
        } 
      } else {
        return i;
      } 
    } else {
      return super.equals(paramObject);
    } 
    return true;
  }
  
  public int hashCode() {
    long l = Double.doubleToLongBits(this.aTu);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.discount);
    int j = (int)(l ^ l >>> 32);
    int k = this.aTv;
    l = Double.doubleToLongBits(this.aJW);
    int m = (int)(l ^ l >>> 32);
    int n = this.name.hashCode();
    l = Double.doubleToLongBits(this.aTw);
    return (((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + (int)(l ^ l >>> 32)) * 31 + (int)(this.aTx ^ this.aTx >>> 32)) * 31 + this.aTa) * 31 + this.aTy.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("支付类型：");
    stringBuilder.append(this.aTv);
    stringBuilder.append(",名称：");
    stringBuilder.append(this.name);
    stringBuilder.append(",金额：");
    stringBuilder.append(this.aJW);
    stringBuilder.append("，具体类型：");
    stringBuilder.append(this.aTx);
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */