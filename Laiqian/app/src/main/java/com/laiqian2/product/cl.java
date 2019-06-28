package com.laiqian.product;

import android.view.View;
import com.laiqian.ui.a.w;

class cl implements View.OnClickListener {
  cl(ck paramck) {}
  
  public void onClick(View paramView) {
    ck.a(this.cRl).requestFocus();
    if (ck.b(this.cRl) != null) {
      ck.a(this.cRl, new w(ck.c(this.cRl), ck.b(this.cRl), new cm(this)));
      ck.j(this.cRl).gn(ck.i(this.cRl));
      ck.j(this.cRl).show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */