package com.laiqian.scales.c;

import android.support.annotation.NonNull;

public class a extends b {
  private static final String TAG = "a";
  
  private final double aJW;
  
  private final double cpn;
  
  static  {
  
  }
  
  public a(double paramDouble1, double paramDouble2, double paramDouble3) {
    super(paramDouble1);
    this.cpn = paramDouble2;
    this.aJW = paramDouble3;
  }
  
  public static a nF(@NonNull String paramString) throws IllegalArgumentException {
    stringBuilder = paramString.trim().split("\\s+");
    if (stringBuilder.length < 3) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("string not complete: ");
      stringBuilder.append(paramString);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    if (stringBuilder.length > 3) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("string malformation: ");
      stringBuilder.append(paramString);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    try {
      int i = Integer.parseInt(stringBuilder[0]);
      int j = Integer.parseInt(stringBuilder[1]);
      int k = Integer.parseInt(stringBuilder[2]);
      return new a(i / 1000.0D, j / 100.0D, k / 100.0D);
    } catch (NumberFormatException stringBuilder) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("malformation: ");
      stringBuilder1.append(paramString);
      IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder1.toString());
      illegalArgumentException.initCause(stringBuilder);
      throw illegalArgumentException;
    } 
  }
  
  public double AO() { return this.aJW; }
  
  public double akI() { return this.cpn; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(TAG);
    stringBuilder.append(" 重量: %fkg 单价: %f 总价: %f");
    return String.format(stringBuilder.toString(), new Object[] { Double.valueOf(getWeight()), Double.valueOf(akI()), Double.valueOf(AO()) });
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scales\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */