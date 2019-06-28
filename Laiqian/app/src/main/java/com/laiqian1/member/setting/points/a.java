package com.laiqian.member.setting.points;

import com.laiqian.d.a;

public class a {
  private int bFu = 100;
  
  private boolean bFv = false;
  
  private double bFw = 1.0D;
  
  private double bFx = 1.0D;
  
  private boolean bFy = true;
  
  public static a SG() {
    a a1 = new a();
    a1.bFv = a.AZ().BB();
    a1.bFy = a.AZ().Cd();
    a1.bFu = a.AZ().BC();
    a1.bFx = ((Double)(a.AZ().Ce()).second).doubleValue();
    a1.bFw = ((Double)(a.AZ().Ce()).first).doubleValue();
    return a1;
  }
  
  public int SA() { return this.bFu; }
  
  public boolean SB() { return this.bFv; }
  
  public double SC() { return this.bFw; }
  
  public double SD() { return this.bFx; }
  
  public boolean SE() { return this.bFy; }
  
  public a SF() {
    a a1 = new a();
    a1.bFu = this.bFu;
    a1.bFy = this.bFy;
    a1.bFv = this.bFv;
    a1.bFx = this.bFx;
    a1.bFw = this.bFw;
    return a1;
  }
  
  public void ap(double paramDouble) { this.bFw = paramDouble; }
  
  public void aq(double paramDouble) { this.bFx = paramDouble; }
  
  public void dZ(boolean paramBoolean) { this.bFv = paramBoolean; }
  
  public void ea(boolean paramBoolean) { this.bFy = paramBoolean; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof a))
      return false; 
    paramObject = (a)paramObject;
    return (this.bFy != paramObject.bFy) ? false : ((this.bFv != paramObject.bFv) ? false : ((Double.doubleToLongBits(this.bFu) != Double.doubleToLongBits(paramObject.bFu)) ? false : ((this.bFw != paramObject.bFw) ? false : (!(this.bFx != paramObject.bFx)))));
  }
  
  public void fV(int paramInt) { this.bFu = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\points\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */