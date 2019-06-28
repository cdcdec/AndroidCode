package com.laiqian.pos.settings;

import android.view.View;
import kotlin.Metadata;

@Metadata
final class cy implements View.OnClickListener {
  cy(ShopInfoSettingsActivity paramShopInfoSettingsActivity) {}
  
  public final void onClick(View paramView) {
    ShopInfoSettingsActivity.a(this.cBN, ShopInfoSettingsActivity.cBL.adP());
    this.cBN.hw(ShopInfoSettingsActivity.cBL.adP());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */