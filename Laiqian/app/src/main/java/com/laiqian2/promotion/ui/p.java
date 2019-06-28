package com.laiqian.promotion.ui;

import android.view.View;
import com.laiqian.entity.ac;
import com.laiqian.promotion.R;

class p implements View.OnClickListener {
  p(PromotionCreateActivity paramPromotionCreateActivity) {}
  
  public void onClick(View paramView) {
    if (PromotionCreateActivity.d(this.cWA) != null)
      PromotionCreateActivity.d(this.cWA).dismiss(); 
    ac ac = PromotionCreateActivity.b(this.cWA).alm();
    int i = PromotionCreateActivity.b(this.cWA).all();
    int j = ((Integer)paramView.getTag()).intValue();
    if (paramView.getId() == R.id.btn_delete)
      PromotionCreateActivity.c(this.cWA).g(ac.getID(), i); 
    if (paramView.getId() == R.id.btn_pause) {
      if (1 == j) {
        PromotionCreateActivity.c(this.cWA).b(ac.getID(), i, true);
        return;
      } 
      if (2 == j)
        PromotionCreateActivity.c(this.cWA).b(ac.getID(), i, false); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */