package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.view.View;

class gq implements View.OnClickListener {
  gq(WeshopPaymentSettingsFragment paramWeshopPaymentSettingsFragment) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.cxj.getActivity(), WeshopCouponsActivity.class);
    intent.putExtra("couponList", this.cxj.cxi.ach());
    this.cxj.startActivityForResult(intent, 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */