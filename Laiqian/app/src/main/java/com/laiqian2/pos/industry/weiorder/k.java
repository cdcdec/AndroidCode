package com.laiqian.pos.industry.weiorder;

public class k {
  private final String aSI;
  
  private boolean aSJ = false;
  
  private boolean aSK = false;
  
  private boolean aSL = false;
  
  private boolean aSN = true;
  
  private boolean aSO = true;
  
  private String aSP = "";
  
  private String aSQ = "";
  
  private boolean aSR = true;
  
  private boolean aSS = true;
  
  private boolean csC = false;
  
  private double discount = 100.0D;
  
  public k(String paramString) { this.aSI = paramString; }
  
  public boolean FA() { return this.aSS; }
  
  public String FC() { return this.aSP; }
  
  public String FD() { return this.aSQ; }
  
  public boolean FE() { return this.aSN; }
  
  public boolean FF() { return this.aSO; }
  
  public boolean FG() { return this.aSK; }
  
  public boolean FH() { return this.aSL; }
  
  public double FI() { return this.discount; }
  
  public boolean Fz() { return this.aSR; }
  
  public boolean aaZ() { return this.aSJ; }
  
  public boolean aba() { return this.csC; }
  
  public k abb() {
    k k1 = new k(this.aSI);
    k1.aSN = this.aSN;
    k1.aSO = this.aSO;
    k1.aSK = this.aSK;
    k1.aSL = this.aSL;
    k1.discount = this.discount;
    k1.aSP = this.aSP;
    k1.aSQ = this.aSQ;
    k1.aSR = this.aSR;
    k1.aSS = this.aSS;
    k1.csC = this.csC;
    return k1;
  }
  
  public void cC(boolean paramBoolean) { this.aSR = paramBoolean; }
  
  public void cD(boolean paramBoolean) { this.aSS = paramBoolean; }
  
  public void cF(boolean paramBoolean) { this.aSN = paramBoolean; }
  
  public void cG(boolean paramBoolean) { this.aSO = paramBoolean; }
  
  void cH(boolean paramBoolean) { this.aSJ = paramBoolean; }
  
  public void cI(boolean paramBoolean) { this.aSK = paramBoolean; }
  
  public void cJ(boolean paramBoolean) { this.aSL = paramBoolean; }
  
  public void dh(String paramString) { this.aSP = paramString; }
  
  public void di(String paramString) { this.aSQ = paramString; }
  
  public void eY(boolean paramBoolean) { this.csC = paramBoolean; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof k))
      return false; 
    paramObject = (k)paramObject;
    return (this.aSK != paramObject.aSK) ? false : ((this.aSN != paramObject.aSN) ? false : ((this.aSO != paramObject.aSO) ? false : ((this.aSL != paramObject.aSL) ? false : ((this.discount != paramObject.discount) ? false : ((this.aSR != paramObject.aSR) ? false : ((this.aSS != paramObject.aSS) ? false : (!(this.csC != paramObject.csC))))))));
  }
  
  public void p(double paramDouble) { this.discount = paramDouble; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */