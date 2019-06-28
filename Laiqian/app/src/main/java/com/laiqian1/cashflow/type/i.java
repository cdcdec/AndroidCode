package com.laiqian.cashflow.type;

import android.view.View;
import android.widget.Toast;
import com.laiqian.cashflow.b.c;
import io.reactivex.g.a;

class i implements View.OnClickListener {
  i(f paramf) {}
  
  public void onClick(View paramView) {
    c c = new c(f.a(this.aKl));
    String str = f.e(this.aKl).getText().toString();
    if ("".equals(str)) {
      Toast.makeText(f.a(this.aKl), f.a(this.aKl).getString(2131624612), 1).show();
      return;
    } 
    if (str.contains("'")) {
      Toast.makeText(f.a(this.aKl), f.a(this.aKl).getString(2131624609), 1).show();
      return;
    } 
    if (c.c(str, f.f(this.aKl).getID())) {
      f.a(this.aKl, c.Vn());
      return;
    } 
    boolean bool = c.b(f.b(this.aKl), str, f.d(this.aKl));
    c.close();
    if (bool) {
      Toast.makeText(f.a(this.aKl), f.a(this.aKl).getString(2131630233), 1).show();
      a.aKh().r(new c.a(f.b(this.aKl), 2));
      if (f.c(this.aKl) != null)
        f.c(this.aKl).c(f.b(this.aKl), "", f.d(this.aKl)); 
    } else {
      Toast.makeText(f.a(this.aKl), f.a(this.aKl).getString(2131630232), 1).show();
      if (f.c(this.aKl) != null)
        f.c(this.aKl).bH(c.Vn()); 
    } 
    this.aKl.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\type\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */