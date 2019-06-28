package com.laiqian.member.setting.marketing;

import android.content.Intent;
import android.view.View;
import com.laiqian.basic.RootApplication;

class w implements View.OnClickListener {
  w(MarketSettingFragment paramMarketSettingFragment) {}
  
  public void onClick(View paramView) {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
      return; 
    this.bEW.startActivity(new Intent(this.bEW.getActivity(), DiscountMarketActivity.class));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */