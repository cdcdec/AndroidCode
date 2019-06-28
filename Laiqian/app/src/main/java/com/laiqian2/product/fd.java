package com.laiqian.product;

import android.view.View;

class fd implements View.OnClickListener {
  fd(fa paramfa) {}
  
  public void onClick(View paramView) {
    boolean bool = this.cUa.save();
    if (fa.b(this.cUa) != null) {
      boolean bool1;
      String str1 = fa.c(this.cUa).getText().toString();
      if (fa.d(this.cUa) == null) {
        fa.b(this.cUa).a(bool, fa.e(this.cUa), str1, fa.f(this.cUa).isChecked());
        return;
      } 
      fa.a a = fa.b(this.cUa);
      String str2 = fa.d(this.cUa);
      boolean bool2 = fa.f(this.cUa).isChecked();
      int i = fa.g(this.cUa);
      if (fa.h(this.cUa) == null) {
        bool1 = true;
      } else {
        bool1 = fa.h(this.cUa).isChecked();
      } 
      a.a(bool, str2, str1, bool2, i, bool1);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */