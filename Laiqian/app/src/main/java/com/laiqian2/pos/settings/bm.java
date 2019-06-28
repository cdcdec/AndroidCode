package com.laiqian.pos.settings;

import android.view.View;
import kotlin.Metadata;

@Metadata
final class bm implements View.OnClickListener {
  bm(ShopDeviceModeSettingFragment paramShopDeviceModeSettingFragment) {}
  
  public final void onClick(View paramView) {
    if (ShopDeviceModeSettingFragment.f(this.cBf).isSelected())
      ShopDeviceModeSettingFragment.g(this.cBf).show(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */