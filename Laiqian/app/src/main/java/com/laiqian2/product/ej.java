package com.laiqian.product;

import android.view.View;
import com.laiqian.product.models.g.b;

class ej implements View.OnClickListener {
  ej(RawMaterialListActivity paramRawMaterialListActivity) {}
  
  public void onClick(View paramView) {
    b[] arrayOfb = (b[])paramView.getTag();
    RawMaterialListActivity.a.a(RawMaterialListActivity.a(this.cTg), arrayOfb);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */