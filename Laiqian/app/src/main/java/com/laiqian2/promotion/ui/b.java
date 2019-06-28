package com.laiqian.promotion.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class b extends RecyclerView.f {
  b(ProductTypePromotionActivity paramProductTypePromotionActivity) {}
  
  public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    if (paramRecyclerView.aB(paramView) == 0 && ProductTypePromotionActivity.b(this.cWd).tV() == 0)
      paramRect.top = 10; 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */