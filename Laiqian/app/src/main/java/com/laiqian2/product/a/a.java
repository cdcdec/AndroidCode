package com.laiqian.product.a;

import java.io.Serializable;

public class a implements Serializable {
  private final int value;
  
  public a(int paramInt) {
    if (paramInt != 0 && paramInt != 1 && paramInt != -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("illegal value: ");
      stringBuilder.append(paramInt);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    this.value = paramInt;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (a)paramObject;
      return (this.value == paramObject.value);
    } 
    return false;
  }
  
  public int getValue() { return this.value; }
  
  public int hashCode() { return this.value; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ProductAttributeRuleSetting{value=");
    stringBuilder.append(this.value);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */