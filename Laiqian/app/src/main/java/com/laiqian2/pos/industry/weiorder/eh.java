package com.laiqian.pos.industry.weiorder;

import java.io.Serializable;

public class eh implements Serializable {
  double cvC;
  
  double discount;
  
  public eh(double paramDouble1, double paramDouble2) {
    this.cvC = paramDouble1;
    this.discount = paramDouble2;
  }
  
  public double FI() { return this.discount; }
  
  public void aC(double paramDouble) { this.cvC = paramDouble; }
  
  public double abM() { return this.cvC; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof eh))
      return false; 
    paramObject = (eh)paramObject;
    return (this.cvC != paramObject.cvC) ? false : (!(this.discount != paramObject.discount));
  }
  
  public void p(double paramDouble) { this.discount = paramDouble; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */