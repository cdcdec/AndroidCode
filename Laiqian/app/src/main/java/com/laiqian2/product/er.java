package com.laiqian.product;

import android.view.View;
import com.laiqian.util.n;

class er implements View.OnClickListener {
  er(eo parameo) {}
  
  public void onClick(View paramView) {
    eo.a a = (eo.a)paramView.getTag();
    if (a.cTC < 1) {
      n.o("可选商品数量为0");
      return;
    } 
    while (a.cTC <= a.cTB.size()) {
      View view = (View)a.cTB.remove(0);
      eo.a a1 = (eo.a)view.getTag();
      a1.cTD--;
      if (a1.cTD < 0)
        a1.cTD = 0; 
      eo.a(this.cTz, view, a1.blj, a1.cTD);
    } 
    eo.a(this.cTz, paramView);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */