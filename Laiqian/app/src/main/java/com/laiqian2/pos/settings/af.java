package com.laiqian.pos.settings;

import com.laiqian.ui.a.r;

class af implements r.a {
  af(ab paramab) {}
  
  public void xD() { ab.d(this.cAa).cancel(); }
  
  public void xE() {
    boolean bool = this.cAa.delete();
    ab.d(this.cAa).cancel();
    if (ab.a(this.cAa) != null)
      ab.a(this.cAa).f(bool, ab.c(this.cAa), ab.b(this.cAa).getText().toString()); 
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */