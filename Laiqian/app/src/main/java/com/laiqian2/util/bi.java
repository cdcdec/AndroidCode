package com.laiqian.util;

import com.laiqian.basic.RootApplication;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class bi {
  public static String ax(double paramDouble) { return c(paramDouble, RootApplication.aIQ); }
  
  public static String c(double paramDouble, int paramInt) {
    DecimalFormat decimalFormat = new DecimalFormat("0");
    decimalFormat.setMaximumFractionDigits(paramInt);
    decimalFormat.setMinimumFractionDigits(paramInt);
    decimalFormat.setMinimumIntegerDigits(1);
    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    return decimalFormat.format(paramDouble);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */