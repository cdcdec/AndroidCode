package com.laiqian.member.setting.sms;

import android.content.Intent;
import android.view.View;

class l implements View.OnClickListener {
  l(SmsSettingFragment paramSmsSettingFragment) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.bGR.getActivity(), com.laiqian.member.setting.marketing.DiscountMarketActivity.class);
    this.bGR.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */