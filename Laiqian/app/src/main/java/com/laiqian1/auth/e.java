package com.laiqian.auth;

import com.laiqian.ui.a.r;

class e implements r.a {
  e(a parama) {}
  
  public void xD() { a.e(this.aCV).cancel(); }
  
  public void xE() {
    boolean bool = this.aCV.delete();
    a.e(this.aCV).cancel();
    if (a.b(this.aCV) != null)
      a.b(this.aCV).c(bool, a.c(this.aCV), a.a(this.aCV).getText().toString()); 
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */