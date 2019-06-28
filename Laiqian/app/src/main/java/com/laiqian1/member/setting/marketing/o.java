package com.laiqian.member.setting.marketing;

import android.text.TextUtils;
import android.view.View;
import com.laiqian.ui.a.bc;
import com.laiqian.util.bd;

class o implements ad.a {
  o(DiscountMarketActivity paramDiscountMarketActivity) {}
  
  public void onClick(View paramView) {
    this.bED.bEf = DiscountMarketActivity.b(this.bED).Sy();
    if (DiscountMarketActivity.c(this.bED))
      return; 
    if (!bd.bH(this.bED)) {
      (new bc(this.bED)).show();
    } else if (TextUtils.isEmpty(this.bED.bEf)) {
      DiscountMarketActivity.d(this.bED);
    } else if (this.bED.bEf.split(",").length * Integer.valueOf(DiscountMarketActivity.e(this.bED)).intValue() < this.bED.bEe.Su()) {
      DiscountMarketActivity.f(this.bED);
    } else {
      DiscountMarketActivity.g(this.bED);
    } 
    DiscountMarketActivity.b(this.bED).dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */