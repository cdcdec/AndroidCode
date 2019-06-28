package com.laiqian.promotion.ui;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.b.a;
import com.laiqian.product.models.ProductTypeEntity;

class c extends a {
  c(ProductTypePromotionActivity paramProductTypePromotionActivity) {}
  
  public void f(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt) {
    ProductTypeEntity productTypeEntity = (ProductTypeEntity)ProductTypePromotionActivity.b(this.cWd).tS().get(paramInt);
    if (productTypeEntity != null) {
      productTypeEntity.cVg ^= true;
      ProductTypePromotionActivity.b(this.cWd).bK(paramInt);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */