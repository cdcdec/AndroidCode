package com.laiqian.product;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.product.models.a;

class g implements AdapterView.OnItemClickListener {
  g(MealSetActivity paramMealSetActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    a a = (a)paramAdapterView.getItemAtPosition(paramInt);
    MealSetActivity.a(this.cPa, a);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */