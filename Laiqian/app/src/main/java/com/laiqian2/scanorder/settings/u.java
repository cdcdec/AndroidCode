package com.laiqian.scanorder.settings;

class u implements f.a {
  u(PayAndFeeFragment paramPayAndFeeFragment) {}
  
  public void a(f paramf) { paramf.dismiss(); }
  
  public void a(f paramf, String paramString, double paramDouble, int paramInt) {
    n n = paramf.aoQ();
    if (n == null) {
      (new PayAndFeeFragment.b(this.djj, paramf, paramString, paramDouble, paramInt)).execute(new Void[0]);
      return;
    } 
    (new PayAndFeeFragment.e(this.djj, paramf, n, paramString, paramDouble, paramInt)).execute(new Void[0]);
  }
  
  public void b(f paramf) {
    n n = paramf.aoQ();
    if (n != null)
      (new PayAndFeeFragment.d(this.djj, paramf, n)).execute(new Void[0]); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\setting\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */