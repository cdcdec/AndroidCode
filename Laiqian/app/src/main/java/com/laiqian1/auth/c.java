package com.laiqian.auth;

import android.view.View;

class c implements View.OnClickListener {
  c(a parama) {}
  
  public void onClick(View paramView) {
    String str = a.a(this.aCV).getText().toString();
    if (!a.a(this.aCV, str))
      return; 
    boolean bool = a.b(this.aCV, str);
    if (a.b(this.aCV) != null) {
      if (a.c(this.aCV) == null) {
        a.b(this.aCV).a(bool, a.d(this.aCV), str);
        return;
      } 
      a.b(this.aCV).b(bool, a.c(this.aCV), str);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */