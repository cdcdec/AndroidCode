package com.laiqian.pos;

import com.laiqian.ui.a.r;

class af implements r.a {
  af(ab paramab) {}
  
  public void xD() { ab.d(this.cfv).cancel(); }
  
  public void xE() {
    boolean bool = this.cfv.delete();
    ab.d(this.cfv).cancel();
    if (ab.a(this.cfv) != null)
      ab.a(this.cfv).f(bool, ab.c(this.cfv), ab.b(this.cfv).getText().toString()); 
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */