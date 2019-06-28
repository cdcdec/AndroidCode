package com.laiqian.promotion.ui;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.b.a;
import com.laiqian.entity.ac;
import com.laiqian.promotion.R;

class e extends a {
  e(PromotionCreateActivity paramPromotionCreateActivity) {}
  
  public void a(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt) {
    if (paramView.getId() == R.id.tv_promotion_state) {
      if (!PromotionCreateActivity.a(this.cWA) && PromotionCreateActivity.b(this.cWA).all() != paramInt) {
        PromotionCreateActivity.a(this.cWA, false, paramInt, true, paramView);
        return;
      } 
      PromotionCreateActivity.a(this.cWA, paramView, paramInt, false);
    } 
  }
  
  public void f(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt) {
    if (paramInt != PromotionCreateActivity.b(this.cWA).all()) {
      if (!PromotionCreateActivity.a(this.cWA)) {
        PromotionCreateActivity.a(this.cWA, false, paramInt, false, null);
        return;
      } 
      PromotionCreateActivity.b(this.cWA).jz(paramInt);
      PromotionCreateActivity.c(this.cWA).b((ac)PromotionCreateActivity.b(this.cWA).tS().get(paramInt));
      this.cWA.c((ac)PromotionCreateActivity.b(this.cWA).tS().get(paramInt));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */