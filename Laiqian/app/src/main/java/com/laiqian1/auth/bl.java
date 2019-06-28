package com.laiqian.auth;

import android.view.View;

class bl implements View.OnClickListener {
  bl(ShopInfo paramShopInfo) {}
  
  public void onClick(View paramView) {
    if (this.aFs.aFq == null)
      this.aFs.aFq = new String[] { "1", "2", "3", "4", "5", this.aFs.getString(2131628242) }; 
    ShopInfo.a(this.aFs, this.aFs.aFq, new bm(this), ShopInfo.f(this.aFs).getText().toString().trim());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */