package com.laiqian.product;

import android.view.View;
import com.laiqian.product.models.a;

class j implements View.OnClickListener {
  j(MealSetActivity.a parama) {}
  
  public void onClick(View paramView) {
    int i = ((Integer)paramView.getTag()).intValue();
    if (!paramView.isActivated())
      MealSetActivity.a(this.cPc.cPa, i); 
    a a1 = this.cPc.jj(i);
    MealSetActivity.a(this.cPc.cPa).e(a1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */