package com.laiqian.product;

import android.content.Intent;
import android.view.View;

class i implements View.OnClickListener {
  i(MealSetActivity paramMealSetActivity) {}
  
  public void onClick(View paramView) {
    MealSetActivity.b b = MealSetActivity.a(this.cPa, paramView);
    if (b != null) {
      Intent intent = new Intent(this.cPa, ProductList.class);
      intent.putExtra("productIDs", b.cPh);
      intent.putExtra("productItemIndex", MealSetActivity.d(this.cPa).indexOfChild(b.cPe));
      this.cPa.startActivityForResult(intent, 2);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */