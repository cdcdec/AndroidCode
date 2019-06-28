package com.laiqian.cashflow;

import android.view.View;
import android.widget.Toast;
import com.laiqian.cashflow.b.a;
import io.reactivex.g.a;

class g implements View.OnClickListener {
  g(a parama) {}
  
  public void onClick(View paramView) {
    a a1 = new a(a.a(this.aJA));
    String str1 = a.i(this.aJA).getText().toString();
    String str2 = a.j(this.aJA).getText().toString();
    String str3 = a.f(this.aJA).getText().toString();
    if ("".equals(str1)) {
      Toast.makeText(a.a(this.aJA), a.a(this.aJA).getString(2131624611), 1).show();
      return;
    } 
    if (a.k(this.aJA) == 0L) {
      Toast.makeText(a.a(this.aJA), a.a(this.aJA).getString(2131624604), 1).show();
      return;
    } 
    long l = System.currentTimeMillis();
    if (a1.a(l, str1, a.d(this.aJA), a.k(this.aJA), str3, l, str2)) {
      a.aKh().r(new a.a(l, true));
      if (a.l(this.aJA) != null)
        a.l(this.aJA).a(l, a.d(this.aJA), a.k(this.aJA), a1.Vn()); 
    } else if (a.l(this.aJA) != null) {
      a.l(this.aJA).bH(a1.Vn());
    } 
    a1.close();
    this.aJA.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */