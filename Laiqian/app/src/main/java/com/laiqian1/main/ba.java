package com.laiqian.main;

import android.view.View;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.ui.a.ax;

class ba implements View.OnLongClickListener {
  ba(ar paramar) {}
  
  public boolean onLongClick(View paramView) {
    if (ar.k(this.bbM)) {
      ProductTypeEntity productTypeEntity = (ProductTypeEntity)paramView.getTag();
      if (productTypeEntity != null) {
        ((ax)ar.l(this.bbM).get()).aT(productTypeEntity);
        return true;
      } 
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */