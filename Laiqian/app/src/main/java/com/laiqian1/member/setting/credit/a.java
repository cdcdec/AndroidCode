package com.laiqian.member.setting.credit;

public class a {
  public double aEt;
  
  public boolean bCX;
  
  public a RW() {
    a a1 = new a();
    a1.bCX = this.bCX;
    a1.aEt = this.aEt;
    return a1;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof a))
      return false; 
    paramObject = (a)paramObject;
    return (this.bCX != paramObject.bCX) ? false : (!(this.aEt != paramObject.aEt));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\credit\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */