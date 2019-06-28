package com.laiqian.pos;

import android.text.TextUtils;
import com.laiqian.basic.RootApplication;
import com.laiqian.pos.settings.z;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class bm {
  public static boolean a(double paramDouble1, double paramDouble2, int paramInt) {
    BigDecimal bigDecimal1 = new BigDecimal(paramDouble1);
    BigDecimal bigDecimal2 = new BigDecimal(paramDouble2);
    return (bigDecimal1.setScale(paramInt, 4).compareTo(bigDecimal2.setScale(paramInt, 4)) == 0);
  }
  
  public static String ax(double paramDouble) { return c(paramDouble, RootApplication.aIQ); }
  
  public static String c(double paramDouble, int paramInt) {
    DecimalFormat decimalFormat = new DecimalFormat("0");
    decimalFormat.setMaximumFractionDigits(paramInt);
    decimalFormat.setMinimumFractionDigits(paramInt);
    decimalFormat.setMinimumIntegerDigits(1);
    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    return z.kF(decimalFormat.format(paramDouble));
  }
  
  public static String o(String paramString, int paramInt) { return TextUtils.isEmpty(paramString) ? "0.0" : c(Double.parseDouble(paramString), paramInt); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */