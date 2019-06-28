package com.laiqian.util;

import java.math.BigDecimal;

public class d {
  public static double b(double paramDouble1, double paramDouble2, int paramInt) {
    if (paramInt < 0)
      throw new IllegalArgumentException("The scale must be a positive integer or zero"); 
    return (new BigDecimal(Double.toString(paramDouble1))).divide(new BigDecimal(Double.toString(paramDouble2)), paramInt, 4).doubleValue();
  }
  
  public static double c(double paramDouble1, double paramDouble2) { return (new BigDecimal(Double.toString(paramDouble1))).add(new BigDecimal(Double.toString(paramDouble2))).doubleValue(); }
  
  public static double d(double paramDouble1, double paramDouble2) { return (new BigDecimal(Double.toString(paramDouble1))).subtract(new BigDecimal(Double.toString(paramDouble2))).doubleValue(); }
  
  public static double e(double paramDouble1, double paramDouble2) { return (new BigDecimal(Double.toString(paramDouble1))).multiply(new BigDecimal(Double.toString(paramDouble2))).doubleValue(); }
  
  public static double f(double paramDouble1, double paramDouble2) { return (paramDouble2 == 0.0D) ? -1.0D : b(paramDouble1, paramDouble2, 10); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */