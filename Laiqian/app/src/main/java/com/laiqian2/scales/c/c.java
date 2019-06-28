package com.laiqian.scales.c;

import android.support.annotation.NonNull;

public class c extends b {
  public c(double paramDouble) { super(paramDouble); }
  
  public static c nG(@NonNull String paramString) throws IllegalArgumentException {
    if (!"".equals(paramString)) {
      if (paramString.contains("kg") && paramString.contains("--"))
        throw new IllegalArgumentException("超重"); 
      return paramString.contains("kg") ? new c(Double.valueOf(paramString.substring(0, paramString.indexOf("kg")).replace(" ", "")).doubleValue()) : null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("string not complete: ");
    stringBuilder.append(paramString);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scales\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */