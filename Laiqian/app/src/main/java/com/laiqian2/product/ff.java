package com.laiqian.product;

import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class ff implements w.a {
  ff(fa paramfa) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    fa.a(this.cUa, paramInt);
    switch (paramInt) {
      default:
        return;
      case 2:
        fa.i(this.cUa).setText(this.cUa.getContext().getString(R.string.hot_sale_rules_by_custom));
        return;
      case 1:
        fa.i(this.cUa).setText(this.cUa.getContext().getString(R.string.hot_sale_rules_by_every_type));
        return;
      case 0:
        break;
    } 
    fa.i(this.cUa).setText(this.cUa.getContext().getString(R.string.hot_sale_rules_by_one_month_sale_top_10));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */