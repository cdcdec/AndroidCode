package com.laiqian.product;

import android.content.Intent;
import com.laiqian.infrastructure.R;
import com.laiqian.product.models.g;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.util.n;
import java.util.HashMap;

class de implements w.a {
  de(ProductList paramProductList) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    HashMap hashMap = (HashMap)ProductList.a(this.cRN).YP().get(paramInt);
    String str = (String)hashMap.get("id");
    g g = new g(this.cRN);
    boolean bool = g.a(ProductList.n(this.cRN), ProductList.c(this.cRN).ajO(), ProductList.c(this.cRN).ajP(), ProductList.c(this.cRN).ajN(), str, ProductList.a(this.cRN).Q(hashMap));
    g.close();
    if (bool) {
      n.w(this.cRN, R.string.pos_product_updated);
      ProductList.a(this.cRN, paramInt + ProductList.o(this.cRN).getHeaderViewsCount());
      this.cRN.sendBroadcast(new Intent("pos_activity_change_data_product"));
      return;
    } 
    n.w(this.cRN, R.string.pos_product_batch_fail);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */