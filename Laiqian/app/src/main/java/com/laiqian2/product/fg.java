package com.laiqian.product;

import com.laiqian.ui.a.r;

class fg implements r.a {
  fg(fa paramfa) {}
  
  public void xD() { fa.j(this.cUa).cancel(); }
  
  public void xE() {
    boolean bool = this.cUa.delete();
    fa.j(this.cUa).cancel();
    if (fa.b(this.cUa) != null)
      fa.b(this.cUa).c(bool, fa.d(this.cUa), fa.c(this.cUa).getText().toString()); 
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */