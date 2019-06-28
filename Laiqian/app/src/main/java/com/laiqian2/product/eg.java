package com.laiqian.product;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.product.models.ProductTypeEntity;

class eg implements AdapterView.OnItemClickListener {
  eg(ProductTypeDiscount paramProductTypeDiscount) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    ProductTypeEntity productTypeEntity = (ProductTypeEntity)paramAdapterView.getItemAtPosition(paramInt);
    if (productTypeEntity != null) {
      productTypeEntity.cVd ^= true;
      this.cSV.cST.notifyDataSetChanged();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */