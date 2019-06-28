package com.laiqian.models;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;

@Keep
public class n {
  private final boolean bPm;
  
  private final String name;
  
  private final double value;
  
  public n(@NonNull String paramString, double paramDouble) { this(paramString, paramDouble, true); }
  
  public n(@NonNull String paramString, double paramDouble, boolean paramBoolean) {
    this.name = paramString;
    this.value = paramDouble;
    this.bPm = paramBoolean;
  }
  
  public boolean UZ() { return this.bPm; }
  
  public String getName() { return this.name; }
  
  public double getValue() { return this.value; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */