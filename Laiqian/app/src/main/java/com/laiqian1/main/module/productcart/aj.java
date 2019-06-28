package com.laiqian.main.module.productcart;

import android.view.View;
import com.laiqian.product.models.c;
import com.laiqian.product.models.o;
import com.laiqian.util.n;
import java.util.ArrayList;

class aj implements View.OnClickListener {
  aj(aa paramaa) {}
  
  public void onClick(View paramView) {
    null = aa.d(this.bjW).getText().toString();
    if (null.length() > 0) {
      double d = n.aU(null);
      if (d == 0.0D) {
        this.bjW.bjr.NJ();
        this.bjW.cancel();
        return;
      } 
      this.bjW.bjo.q(d);
    } 
    null = aa.e(this.bjW).getText().toString();
    if (null.length() > 0) {
      double d = n.aU(null);
      this.bjW.bjo.r(d);
    } 
    ArrayList arrayList = c.at(this.bjW.bjs);
    this.bjW.bjo.n(arrayList);
    if (aa.b(this.bjW) != null) {
      arrayList = new ArrayList();
      for (o o : (aa.b(this.bjW)).bka) {
        if (o.cVs)
          arrayList.add(o); 
      } 
      this.bjW.bjo.o(arrayList);
      this.bjW.bjo.GD();
    } 
    this.bjW.NM();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */