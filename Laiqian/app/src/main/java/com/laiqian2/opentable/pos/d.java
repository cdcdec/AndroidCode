package com.laiqian.opentable.pos;

import android.content.Intent;
import android.view.View;
import com.laiqian.ui.a.w;

class d implements View.OnClickListener {
  d(c paramc, Class paramClass) {}
  
  public void onClick(View paramView) {
    if (c.a(this.caV)) {
      Intent intent = new Intent(c.b(this.caV), this.aye);
      intent.putExtra("tableID", Long.valueOf(c.c(this.caV)));
      intent.putExtra("machineType", 1);
      c.d(this.caV).startActivityForResult(intent, 102);
      return;
    } 
    c.e(this.caV).requestFocus();
    if (c.f(this.caV) != null) {
      c.a(this.caV, new w(c.g(this.caV), c.f(this.caV), new e(this)));
      c.k(this.caV).gn(c.j(this.caV));
      c.k(this.caV).show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */