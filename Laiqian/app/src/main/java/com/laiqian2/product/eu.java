package com.laiqian.product;

import android.view.View;

class eu implements View.OnClickListener {
  eu(ServiceChargeActivity paramServiceChargeActivity) {}
  
  public void onClick(View paramView) {
    long[] arrayOfLong = ServiceChargeActivity.c(this.cTF);
    ServiceChargeActivity.b(this.cTF).l(arrayOfLong);
    ServiceChargeActivity.b(this.cTF).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */