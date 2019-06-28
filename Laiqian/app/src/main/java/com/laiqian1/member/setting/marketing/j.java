package com.laiqian.member.setting.marketing;

import android.content.Intent;
import com.laiqian.ui.a.r;

class j implements r.a {
  j(DiscountMarketActivity paramDiscountMarketActivity) {}
  
  public void xD() {}
  
  public void xE() {
    Intent intent = new Intent(this.bED, com.laiqian.member.setting.sms.BuySmsActivity.class);
    intent.putExtra("SMS_QUANTITY_LEFT", this.bED.bEe.Su());
    this.bED.startActivity(intent);
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */