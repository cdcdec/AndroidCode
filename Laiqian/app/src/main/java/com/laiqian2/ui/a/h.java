package com.laiqian.ui.a;

import android.view.View;
import java.util.ArrayList;

class h implements View.OnClickListener {
  h(g paramg) {}
  
  public void onClick(View paramView) {
    if (g.a(this.dzo) != null && g.b(this.dzo) != null) {
      ArrayList arrayList = new ArrayList();
      int i = this.dzo.dAv.getCount();
      for (byte b = 0; b < i; b++) {
        g.b b1 = (g.b)this.dzo.dAv.getItem(b);
        if (g.b(this.dzo).contains(Long.valueOf(b1.AR())))
          arrayList.add(b1); 
      } 
      g.a(this.dzo).a(this.dzo, arrayList);
    } 
    this.dzo.cancel();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */