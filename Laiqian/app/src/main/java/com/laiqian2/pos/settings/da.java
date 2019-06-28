package com.laiqian.pos.settings;

import android.view.View;
import kotlin.Metadata;

@Metadata
final class da implements View.OnClickListener {
  da(ShopInfoSettingsActivity paramShopInfoSettingsActivity) {}
  
  public final void onClick(View paramView) {
    ShopInfoSettingsActivity.a(this.cBN, ShopInfoSettingsActivity.cBL.adR());
    this.cBN.hw(ShopInfoSettingsActivity.cBL.adR());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */