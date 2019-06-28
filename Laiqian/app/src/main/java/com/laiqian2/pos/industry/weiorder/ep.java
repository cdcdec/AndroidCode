package com.laiqian.pos.industry.weiorder;

class ep implements ei.a {
  ep(WeshopCouponsActivity paramWeshopCouponsActivity) {}
  
  public void a(ei paramei) { paramei.dismiss(); }
  
  public void a(ei paramei, double paramDouble1, double paramDouble2) {
    eh eh = paramei.abN();
    if (eh == null) {
      (new WeshopCouponsActivity.b(this.cvJ, paramei, paramDouble1, paramDouble2)).execute(new Void[0]);
      return;
    } 
    (new WeshopCouponsActivity.d(this.cvJ, paramei, eh, paramDouble1, paramDouble2)).execute(new Void[0]);
  }
  
  public void b(ei paramei) {
    eh eh = paramei.abN();
    if (eh != null)
      (new WeshopCouponsActivity.c(this.cvJ, paramei, eh)).execute(new Void[0]); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\ep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */