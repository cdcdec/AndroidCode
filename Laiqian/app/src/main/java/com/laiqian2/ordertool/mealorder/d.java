package com.laiqian.ordertool.mealorder;

import android.content.Intent;
import android.view.View;

class d implements View.OnClickListener {
  d(MealOrderDownloadFragment paramMealOrderDownloadFragment) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent();
    intent.setClass(this.ceh.getActivity(), com.laiqian.ordertool.IPhoneIntro.class);
    this.ceh.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\mealorder\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */