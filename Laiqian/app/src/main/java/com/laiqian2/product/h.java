package com.laiqian.product;

import android.view.View;

class h implements View.OnClickListener {
  h(MealSetActivity paramMealSetActivity) {}
  
  public void onClick(View paramView) {
    MealSetActivity.b b = MealSetActivity.a(this.cPa, paramView);
    if (b != null)
      MealSetActivity.b(this.cPa, b.cPe); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */