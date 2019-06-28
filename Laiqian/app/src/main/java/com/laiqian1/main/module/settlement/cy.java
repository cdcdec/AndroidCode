package com.laiqian.main.module.settlement;

import android.content.Context;

public class cy {
  public static final cy bos = new cy();
  
  public boolean bol;
  
  public boolean bom;
  
  public boolean bon;
  
  public boolean boo;
  
  public boolean bop;
  
  public boolean boq;
  
  private boolean bor;
  
  public boolean OF() { return this.bop; }
  
  public boolean OG() { return this.boq; }
  
  public boolean OH() { return this.bol; }
  
  public boolean OI() { return this.bom; }
  
  public boolean OJ() { return this.boo; }
  
  public boolean OK() { return (!this.bol && !this.bom && !this.bon && !this.boo && !this.bop && !this.boq && !this.bor); }
  
  public String ax(Context paramContext) { return paramContext.getString(2131626370); }
  
  public String ay(Context paramContext) { return paramContext.getString(2131627334); }
  
  public void dt(boolean paramBoolean) { this.bop = paramBoolean; }
  
  public void du(boolean paramBoolean) { this.boq = paramBoolean; }
  
  public void dv(boolean paramBoolean) { this.bor = paramBoolean; }
  
  public void dw(boolean paramBoolean) { this.bol = paramBoolean; }
  
  public void dx(boolean paramBoolean) { this.bom = paramBoolean; }
  
  public void dy(boolean paramBoolean) { this.bon = paramBoolean; }
  
  public void dz(boolean paramBoolean) { this.boo = paramBoolean; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SettlementErrorMessageWrapper{evakoCannotSettleError=");
    stringBuilder.append(this.bol);
    stringBuilder.append(", isUseChainMemberCannotSettleError=");
    stringBuilder.append(this.bom);
    stringBuilder.append(", discountError=");
    stringBuilder.append(this.bon);
    stringBuilder.append(", afterDicountPayError=");
    stringBuilder.append(this.boo);
    stringBuilder.append(", PaidSecondTypeItemBothSacnError=");
    stringBuilder.append(this.bop);
    stringBuilder.append(", PaidSecondTypeItemScanWithGroupError=");
    stringBuilder.append(this.boq);
    stringBuilder.append(", canSettlementWithRoleError=");
    stringBuilder.append(this.bor);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */