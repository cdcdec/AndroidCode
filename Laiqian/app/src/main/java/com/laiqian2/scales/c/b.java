package com.laiqian.scales.c;

public abstract class b {
  private final double diA;
  
  public b(double paramDouble) { this.diA = paramDouble; }
  
  public double getWeight() { return this.diA; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Result{weight=");
    stringBuilder.append(this.diA);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scales\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */