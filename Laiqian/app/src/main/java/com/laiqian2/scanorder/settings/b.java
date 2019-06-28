package com.laiqian.scanorder.settings;

class b implements f.a {
  b(AdditionalFeeItemsActivity paramAdditionalFeeItemsActivity) {}
  
  public void a(f paramf) { paramf.dismiss(); }
  
  public void a(f paramf, String paramString, double paramDouble, int paramInt) {
    n n = paramf.aoQ();
    if (n == null) {
      (new AdditionalFeeItemsActivity.b(this.diF, paramf, paramString, paramDouble, paramInt)).execute(new Void[0]);
      return;
    } 
    (new AdditionalFeeItemsActivity.d(this.diF, paramf, n, paramString, paramDouble, paramInt)).execute(new Void[0]);
  }
  
  public void b(f paramf) {
    n n = paramf.aoQ();
    if (n != null)
      (new AdditionalFeeItemsActivity.c(this.diF, paramf, n)).execute(new Void[0]); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */