package com.laiqian.pos.settings;

import android.view.View;
import com.laiqian.util.n;
import kotlin.Metadata;

@Metadata
final class bl implements View.OnClickListener {
  bl(ShopDeviceModeSettingFragment paramShopDeviceModeSettingFragment) {}
  
  public final void onClick(View paramView) {
    if (ShopDeviceModeSettingFragment.e(this.cBf).isSelected())
      n.eP(2131625740); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */