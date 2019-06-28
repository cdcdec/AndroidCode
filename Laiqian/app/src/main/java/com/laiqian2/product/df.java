package com.laiqian.product;

import android.content.Intent;
import com.laiqian.infrastructure.R;
import com.laiqian.product.models.g;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;

class df implements r.a {
  df(ProductList paramProductList) {}
  
  public void xD() { ProductList.p(this.cRN).cancel(); }
  
  public void xE() {
    g g = new g(this.cRN);
    boolean bool = g.j(ProductList.n(this.cRN));
    g.close();
    ProductList.p(this.cRN).cancel();
    if (bool) {
      n.w(this.cRN, R.string.pos_product_deleted);
      ProductList.c(this.cRN).YQ();
      this.cRN.sendBroadcast(new Intent("pos_activity_change_data_product"));
      return;
    } 
    n.w(this.cRN, R.string.pos_product_batch_fail);
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */