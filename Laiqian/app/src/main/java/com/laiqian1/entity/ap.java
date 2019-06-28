package com.laiqian.entity;

import com.laiqian.ui.a.g;

public class ap implements g.b {
  long aSW;
  
  String aTp;
  
  String name;
  
  public ap(long paramLong, String paramString1, String paramString2) {
    this.aSW = paramLong;
    this.name = paramString1;
    this.aTp = paramString2;
  }
  
  public long AR() { return this.aSW; }
  
  public CharSequence AS() {
    if (this.name == null || this.name.length() == 0)
      return this.aTp; 
    if (this.name.equals(this.aTp))
      return this.aTp; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.aTp);
    stringBuilder.append("  ");
    stringBuilder.append(this.name);
    return stringBuilder.toString();
  }
  
  public CharSequence AT() { return (this.name == null || this.name.length() == 0) ? this.aTp : this.name; }
  
  public long getID() { return this.aSW; }
  
  public String getName() { return this.name; }
  
  public String getPhone() { return this.aTp; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */