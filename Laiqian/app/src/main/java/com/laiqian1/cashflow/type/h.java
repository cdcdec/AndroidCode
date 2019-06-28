package com.laiqian.cashflow.type;

import android.view.View;
import android.widget.Toast;
import com.laiqian.cashflow.b.c;
import io.reactivex.g.a;

class h implements View.OnClickListener {
  h(f paramf) {}
  
  public void onClick(View paramView) {
    c c = new c(f.a(this.aKl));
    boolean bool = c.O(f.b(this.aKl));
    c.close();
    if (bool) {
      Toast.makeText(f.a(this.aKl), f.a(this.aKl).getString(2131630216), 1).show();
      a.aKh().r(new c.a(f.b(this.aKl), 3));
      if (f.c(this.aKl) != null)
        f.c(this.aKl).c(f.b(this.aKl), "", f.d(this.aKl)); 
    } else {
      Toast.makeText(f.a(this.aKl), f.a(this.aKl).getString(2131630215), 1).show();
      if (f.c(this.aKl) != null)
        f.c(this.aKl).bH(c.Vn()); 
    } 
    this.aKl.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\type\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */