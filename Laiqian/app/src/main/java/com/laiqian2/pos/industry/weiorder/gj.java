package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.view.View;

class gj implements View.OnClickListener {
  gj(WeshopMarketingFragment paramWeshopMarketingFragment) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.cwC.getActivity(), com.laiqian.product.ProductList.class);
    intent.putExtra("productIDs", this.cwC.cww.acg());
    this.cwC.startActivityForResult(intent, 2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */