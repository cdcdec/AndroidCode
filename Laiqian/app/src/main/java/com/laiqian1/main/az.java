package com.laiqian.main;

import android.view.View;
import com.laiqian.product.fa;
import com.laiqian.product.models.ProductTypeEntity;

class az implements View.OnClickListener {
  az(ar paramar) {}
  
  public void onClick(View paramView) {
    ProductTypeEntity productTypeEntity = (ProductTypeEntity)paramView.getTag();
    if (productTypeEntity == null) {
      ((fa)ar.d(this.bbM).get()).a(null, null, null, false, null);
      return;
    } 
    ar.a(this.bbM, productTypeEntity);
    ar.f(this.bbM);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */