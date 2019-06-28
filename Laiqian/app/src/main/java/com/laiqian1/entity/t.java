package com.laiqian.entity;

public class t {
  private final String aSI;
  
  private boolean aSJ = false;
  
  private boolean aSK = false;
  
  private boolean aSL = false;
  
  private boolean aSM = false;
  
  private boolean aSN = true;
  
  private boolean aSO = true;
  
  private String aSP = "";
  
  private String aSQ = "";
  
  private boolean aSR = true;
  
  private boolean aSS = true;
  
  private double discount = 100.0D;
  
  public t(String paramString) { this.aSI = paramString; }
  
  public boolean FA() { return this.aSS; }
  
  public boolean FB() { return this.aSM; }
  
  public String FC() { return this.aSP; }
  
  public String FD() { return this.aSQ; }
  
  public boolean FE() { return this.aSN; }
  
  public boolean FF() { return this.aSO; }
  
  public boolean FG() { return this.aSK; }
  
  public boolean FH() { return this.aSL; }
  
  public double FI() { return this.discount; }
  
  public t FJ() {
    t t1 = new t(this.aSI);
    t1.aSN = this.aSN;
    t1.aSO = this.aSO;
    t1.aSK = this.aSK;
    t1.aSL = this.aSL;
    t1.discount = this.discount;
    t1.aSP = this.aSP;
    t1.aSQ = this.aSQ;
    t1.aSR = this.aSR;
    t1.aSS = this.aSS;
    t1.aSM = this.aSM;
    return t1;
  }
  
  public boolean Fz() { return this.aSR; }
  
  public void cC(boolean paramBoolean) { this.aSR = paramBoolean; }
  
  public void cD(boolean paramBoolean) { this.aSS = paramBoolean; }
  
  public void cE(boolean paramBoolean) { this.aSM = paramBoolean; }
  
  public void cF(boolean paramBoolean) { this.aSN = paramBoolean; }
  
  public void cG(boolean paramBoolean) { this.aSO = paramBoolean; }
  
  public void cH(boolean paramBoolean) { this.aSJ = paramBoolean; }
  
  public void cI(boolean paramBoolean) { this.aSK = paramBoolean; }
  
  public void cJ(boolean paramBoolean) { this.aSL = paramBoolean; }
  
  public void dh(String paramString) { this.aSP = paramString; }
  
  public void di(String paramString) { this.aSQ = paramString; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof t))
      return false; 
    paramObject = (t)paramObject;
    return (this.aSK != paramObject.aSK) ? false : ((this.aSN != paramObject.aSN) ? false : ((this.aSO != paramObject.aSO) ? false : ((this.aSL != paramObject.aSL) ? false : ((this.aSM != paramObject.aSM) ? false : ((this.discount != paramObject.discount) ? false : ((this.aSR != paramObject.aSR) ? false : (!(this.aSS != paramObject.aSS))))))));
  }
  
  public void p(double paramDouble) { this.discount = paramDouble; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */