package com.laiqian.entity;

import com.google.a.a.a.a.a.a;
import com.squareup.moshi.Json;
import java.util.Arrays;

public class ae implements Cloneable {
  @Json(name = "giftProductName")
  private String aUA;
  
  @Json(name = "giftType")
  private int aUB;
  
  @Json(name = "giftProductTotalNum")
  private double aUs;
  
  @Json(name = "giftProductIDs")
  private long[] aUx;
  
  @Json(name = "buyProductNum")
  private double aUy;
  
  @Json(name = "giftProductNum")
  private double aUz;
  
  private ae(a parama) {
    this.aUx = a.a(parama);
    this.aUy = a.b(parama);
    this.aUz = a.c(parama);
    this.aUs = a.d(parama);
    this.aUA = a.e(parama);
    this.aUB = a.f(parama);
  }
  
  public long[] Hr() { return this.aUx; }
  
  public double Hs() { return this.aUy; }
  
  public double Ht() { return this.aUz; }
  
  public String Hu() { return this.aUA; }
  
  public int Hv() { return this.aUB; }
  
  public ae Hw() {
    try {
      return (ae)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      a.e(cloneNotSupportedException);
      return null;
    } 
  }
  
  public void M(double paramDouble) { this.aUy = paramDouble; }
  
  public void N(double paramDouble) { this.aUz = paramDouble; }
  
  public void a(long[] paramArrayOfLong) { this.aUx = paramArrayOfLong; }
  
  public void dn(String paramString) { this.aUA = paramString; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (ae)paramObject;
      return (Double.compare(paramObject.aUy, this.aUy) != 0) ? false : ((Double.compare(paramObject.aUz, this.aUz) != 0) ? false : ((Double.compare(paramObject.aUs, this.aUs) != 0) ? false : (!Arrays.equals(this.aUx, paramObject.aUx) ? false : (!(this.aUB != paramObject.aUB)))));
    } 
    return false;
  }
  
  public void ez(int paramInt) { this.aUB = paramInt; }
  
  public int hashCode() {
    int i;
    int j = Arrays.hashCode(this.aUx);
    long l = Double.doubleToLongBits(this.aUy);
    int k = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aUz);
    int m = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aUs);
    int n = (int)(l ^ l >>> 32);
    if (this.aUA != null) {
      i = this.aUA.hashCode();
    } else {
      i = 0;
    } 
    return ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i) * 31 + this.aUB;
  }
  
  public static final class a {
    private String aUA;
    
    private int aUB;
    
    private double aUs;
    
    private long[] aUx;
    
    private double aUy;
    
    private double aUz;
    
    public ae Hx() { return new ae(this, null); }
    
    public a O(double param1Double) {
      this.aUy = param1Double;
      return this;
    }
    
    public a P(double param1Double) {
      this.aUz = param1Double;
      return this;
    }
    
    public a b(long[] param1ArrayOfLong) {
      this.aUx = param1ArrayOfLong;
      return this;
    }
    
    public a do(String param1String) {
      this.aUA = param1String;
      return this;
    }
    
    public a eA(int param1Int) {
      this.aUB = param1Int;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */