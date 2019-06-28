package com.laiqian.product;

import android.view.View;
import android.widget.AdapterView;
import java.util.HashMap;

class cw implements AdapterView.OnItemClickListener {
  cw(ProductList paramProductList) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    HashMap hashMap = (HashMap)paramAdapterView.getItemAtPosition(paramInt);
    if (hashMap != null) {
      if (ProductList.d(this.cRN)) {
        if (!ProductList.g(this.cRN))
          return; 
        if (ProductList.h(this.cRN)) {
          boolean bool = ProductList.c(this.cRN).R(hashMap);
          ((ProductList.a.a)paramView.getTag()).cdt.setSelected(bool ^ true);
          if (bool) {
            ProductList.c(this.cRN).O(hashMap);
          } else {
            ProductList.c(this.cRN).P(hashMap);
          } 
          ProductList.c(this.cRN).ajQ();
          return;
        } 
        ProductList.a(this.cRN, hashMap);
        return;
      } 
      ProductList.c(this.cRN).U(hashMap);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */