package com.laiqian.cashflow.type;

import android.view.View;
import android.widget.Toast;
import com.laiqian.cashflow.b.c;
import io.reactivex.g.a;

class e implements View.OnClickListener {
  e(a parama) {}
  
  public void onClick(View paramView) {
    c c = new c(a.a(this.aKf));
    String str = a.e(this.aKf).getText().toString();
    if ("".equals(str)) {
      Toast.makeText(a.a(this.aKf), a.a(this.aKf).getString(2131624612), 1).show();
      return;
    } 
    if (str.contains("'")) {
      Toast.makeText(a.a(this.aKf), a.a(this.aKf).getString(2131624609), 1).show();
      return;
    } 
    if (c.bN(str)) {
      a.a(this.aKf, c.Vn());
      return;
    } 
    long l = System.currentTimeMillis();
    boolean bool = c.a(l, str, a.f(this.aKf));
    c.close();
    if (bool) {
      Toast.makeText(a.a(this.aKf), a.a(this.aKf).getString(2131630213), 1).show();
      a.aKh().r(new c.a(l, true));
      if (a.g(this.aKf) != null)
        a.g(this.aKf).c(l, str, a.f(this.aKf)); 
    } else {
      Toast.makeText(a.a(this.aKf), a.a(this.aKf).getString(2131630212), 1).show();
      if (a.g(this.aKf) != null)
        a.g(this.aKf).bH(c.Vn()); 
    } 
    this.aKf.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\type\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */