package com.laiqian.auth;

import android.view.View;

class bj implements View.OnClickListener {
  bj(ShopInfo paramShopInfo) {}
  
  public void onClick(View paramView) {
    if (this.aFs.aFo == null)
      this.aFs.aFo = new String[] { this.aFs.getString(2131628244), "50-100", this.aFs.getString(2131628241) }; 
    ShopInfo.a(this.aFs, this.aFs.aFo, new bk(this), ShopInfo.e(this.aFs).getText().toString().trim());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */