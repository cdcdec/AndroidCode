package com.laiqian.product;

import android.view.View;
import com.laiqian.util.n;
import com.zhuge.analysis.b.a;

class en implements View.OnClickListener {
  en(RawMaterialListActivity.c paramc, RawMaterialListActivity paramRawMaterialListActivity) {}
  
  public void onClick(View paramView) {
    String str = this.cTt.akh();
    if (str == null) {
      this.cTt.cancel();
      RawMaterialListActivity.a.c(RawMaterialListActivity.a(this.cTt.cTg));
      this.cTt.cTg.cTf = true;
      a.aAU().Q(this.cTt.cTg, RawMaterialListActivity.c.b(this.cTt));
      return;
    } 
    n.o(str);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */