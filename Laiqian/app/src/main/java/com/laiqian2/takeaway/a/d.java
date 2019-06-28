package com.laiqian.takeaway.a;

import java.io.Serializable;

public class d implements Serializable {
  double cvC;
  
  double discount;
  
  public d(double paramDouble1, double paramDouble2) {
    this.cvC = paramDouble1;
    this.discount = paramDouble2;
  }
  
  public double FI() { return this.discount; }
  
  public double abM() { return this.cvC; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof d))
      return false; 
    paramObject = (d)paramObject;
    return (this.cvC != paramObject.cvC) ? false : (!(this.discount != paramObject.discount));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */