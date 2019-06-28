package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.view.View;

class an implements View.OnClickListener {
  an(TakeOutMarketingActivity paramTakeOutMarketingActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.ctk.getActivity(), WeshopCouponsActivity.class);
    intent.putExtra("couponList", this.ctk.ctj);
    this.ctk.startActivityForResult(intent, 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */