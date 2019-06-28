package com.laiqian.entity;

import com.google.a.a.a.a.a.a;
import com.squareup.moshi.Json;
import java.util.Arrays;

public class ag implements Cloneable {
  @Json(name = "productIds")
  private long[] aUC;
  
  @Json(name = "productDiscount")
  private double aUD = 100.0D;
  
  @Json(name = "productDiscountPrice")
  private double aUE;
  
  @Json(name = "productDiscountType")
  private int aUF;
  
  @Json(name = "fitProductName")
  private String aUG;
  
  private ag(a parama) {
    c(a.a(parama));
    Q(a.b(parama));
    R(a.c(parama));
    eB(a.d(parama));
    dp(a.e(parama));
  }
  
  public double HA() { return this.aUE; }
  
  public int HB() { return this.aUF; }
  
  public String HC() { return this.aUG; }
  
  public ag HD() {
    try {
      return (ag)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      a.e(cloneNotSupportedException);
      return null;
    } 
  }
  
  public long[] Hy() { return this.aUC; }
  
  public double Hz() { return this.aUD; }
  
  public void Q(double paramDouble) { this.aUD = paramDouble; }
  
  public void R(double paramDouble) { this.aUE = paramDouble; }
  
  public void c(long[] paramArrayOfLong) { this.aUC = paramArrayOfLong; }
  
  public void dp(String paramString) { this.aUG = paramString; }
  
  public void eB(int paramInt) { this.aUF = paramInt; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (ag)paramObject;
      return (Double.compare(paramObject.aUD, this.aUD) != 0) ? false : ((Double.compare(paramObject.aUE, this.aUE) != 0) ? false : ((this.aUF != paramObject.aUF) ? false : (!!Arrays.equals(this.aUC, paramObject.aUC))));
    } 
    return false;
  }
  
  public int hashCode() {
    int i;
    int j = Arrays.hashCode(this.aUC);
    long l = Double.doubleToLongBits(this.aUD);
    int k = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aUE);
    int m = (int)(l ^ l >>> 32);
    int n = this.aUF;
    if (this.aUG != null) {
      i = this.aUG.hashCode();
    } else {
      i = 0;
    } 
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PromotionProductDiscountEntity{productId=");
    stringBuilder.append(Arrays.toString(this.aUC));
    stringBuilder.append(", productDiscount=");
    stringBuilder.append(this.aUD);
    stringBuilder.append(", productDiscountPrice=");
    stringBuilder.append(this.aUE);
    stringBuilder.append(", productDiscountType=");
    stringBuilder.append(this.aUF);
    stringBuilder.append(", fitProductName='");
    stringBuilder.append(this.aUG);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static final class a {
    private long[] aUC;
    
    private double aUD = 100.0D;
    
    private double aUE;
    
    private int aUF;
    
    private String aUG;
    
    public ag HE() { return new ag(this, null); }
    
    public a S(double param1Double) {
      this.aUD = param1Double;
      return this;
    }
    
    public a T(double param1Double) {
      this.aUE = param1Double;
      return this;
    }
    
    public a d(long[] param1ArrayOfLong) {
      this.aUC = param1ArrayOfLong;
      return this;
    }
    
    public a dq(String param1String) {
      this.aUG = param1String;
      return this;
    }
    
    public a eC(int param1Int) {
      this.aUF = param1Int;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */