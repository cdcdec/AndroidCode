package com.laiqian.promotion.a;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.f;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.promotion.R;
import java.util.ArrayList;
import java.util.List;

public class c extends BaseQuickAdapter<ProductTypeEntity, f> {
  private ArrayList<ProductTypeEntity> cVC = new ArrayList();
  
  public c(@Nullable List<ProductTypeEntity> paramList) { super(R.layout.pos_product_type_promotion_item, paramList); }
  
  public void L(List<ProductTypeEntity> paramList) { this.cVC.addAll(paramList); }
  
  public void a(f paramf, int paramInt) {
    super.a(paramf, paramInt);
    int i = getItemCount();
    View view = paramf.dp(R.id.item);
    if (view == null)
      return; 
    if (i == 1) {
      view.setBackgroundResource(R.drawable.selector_rounded_rectangle);
      return;
    } 
    if (paramInt == 0) {
      view.setBackgroundResource(R.drawable.selector_rounded_rectangle_up);
      return;
    } 
    if (paramInt == i - 1) {
      view.setBackgroundResource(R.drawable.selector_rounded_rectangle_down);
      return;
    } 
    view.setBackgroundResource(R.drawable.selector_rounded_rectangle_unupdown);
  }
  
  protected void a(f paramf, ProductTypeEntity paramProductTypeEntity) {
    paramf.a(R.id.promotion_product_type_name, paramProductTypeEntity.name);
    paramf.dp(R.id.promotion_product_type_check).setSelected(paramProductTypeEntity.cVg);
  }
  
  public ArrayList<ProductTypeEntity> alo() {
    this.cVC.clear();
    for (byte b = 0; b < tS().size(); b++) {
      ProductTypeEntity productTypeEntity = (ProductTypeEntity)tS().get(b);
      if (productTypeEntity.cVg)
        this.cVC.add(productTypeEntity); 
    } 
    return this.cVC;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */