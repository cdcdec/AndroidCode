package com.laiqian.product;

import android.view.View;
import com.laiqian.util.bb;
import com.umeng.analytics.MobclickAgent;

class dl implements View.OnClickListener {
  dl(ProductList paramProductList) {}
  
  public void onClick(View paramView) {
    MobclickAgent.onEvent(this.cRN, "product_search");
    bb.e("Umeng", "product_search");
    ProductList.a(this.cRN, true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */