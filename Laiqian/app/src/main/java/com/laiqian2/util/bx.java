package com.laiqian.util;

public final class bx {
  private final String aeh;
  
  private final String dGu;
  
  private StringBuilder dGv;
  
  private String dGw;
  
  private final String prefix;
  
  public bx(CharSequence paramCharSequence) { this(paramCharSequence, "", ""); }
  
  public bx(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3) {
    if (paramCharSequence2 == null)
      throw new NullPointerException("The prefix must not be null"); 
    if (paramCharSequence1 == null)
      throw new NullPointerException("The prefix must not be null"); 
    if (paramCharSequence3 == null)
      throw new NullPointerException("The prefix must not be null"); 
    this.prefix = paramCharSequence2.toString();
    this.aeh = paramCharSequence1.toString();
    this.dGu = paramCharSequence3.toString();
    paramCharSequence1 = new StringBuilder();
    paramCharSequence1.append(this.prefix);
    paramCharSequence1.append(this.dGu);
    this.dGw = paramCharSequence1.toString();
  }
  
  private StringBuilder aww() {
    if (this.dGv != null) {
      this.dGv.append(this.aeh);
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.prefix);
      this.dGv = stringBuilder;
    } 
    return this.dGv;
  }
  
  public String toString() {
    if (this.dGv == null)
      return this.dGw; 
    if (this.dGu.equals(""))
      return this.dGv.toString(); 
    int i = this.dGv.length();
    StringBuilder stringBuilder = this.dGv;
    stringBuilder.append(this.dGu);
    String str = stringBuilder.toString();
    this.dGv.setLength(i);
    return str;
  }
  
  public bx v(CharSequence paramCharSequence) {
    aww().append(paramCharSequence);
    return this;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */