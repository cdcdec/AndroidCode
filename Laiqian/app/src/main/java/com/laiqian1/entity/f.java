package com.laiqian.entity;

import com.google.a.a.a.a.a.a;
import com.laiqian.ui.a.g;
import com.squareup.moshi.Json;
import java.io.Serializable;

public class f implements g.b, Serializable, Cloneable {
  @Json(name = "promotionDiscount")
  private double aRN;
  
  @Json(name = "promotionDiscountPrice")
  private double aRO;
  
  @Json(name = "promotionID")
  private long aRP;
  
  @Json(name = "promotionName")
  private String aRQ;
  
  @Json(name = "isDiscountPriceProduct")
  private boolean aRR;
  
  @Json(name = "isBuyGiftProduct")
  private boolean aRS;
  
  public long AR() { return this.aRP; }
  
  public CharSequence AS() { return this.aRQ; }
  
  public CharSequence AT() { return this.aRQ; }
  
  protected f EJ() {
    try {
      return (f)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      a.e(cloneNotSupportedException);
      return null;
    } 
  }
  
  public double EK() { return this.aRN; }
  
  public double EL() { return this.aRO; }
  
  public boolean EM() { return this.aRR; }
  
  public boolean EN() { return this.aRS; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */