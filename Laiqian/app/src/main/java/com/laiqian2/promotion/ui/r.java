package com.laiqian.promotion.ui;

import android.view.View;
import com.laiqian.promotion.R;
import com.laiqian.util.n;

class r implements View.OnClickListener {
  r(PromotionCreateActivity paramPromotionCreateActivity) {}
  
  public void onClick(View paramView) {
    if (!PromotionCreateActivity.f(this.cWA)) {
      PromotionCreateActivity.a(this.cWA, true);
      PromotionCreateActivity.c(this.cWA).na(PromotionCreateActivity.g(this.cWA));
      return;
    } 
    n.eP(R.string.pos_promotion_only_one_in_creating_status);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */