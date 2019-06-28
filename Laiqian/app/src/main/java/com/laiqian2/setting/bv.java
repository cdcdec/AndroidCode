package com.laiqian.setting;

import android.content.Intent;
import android.view.View;
import com.laiqian.opentable.common.b;
import com.laiqian.ui.a.r;

class bv implements View.OnClickListener {
  bv(SettingOrderDishesFragment paramSettingOrderDishesFragment) {}
  
  public void onClick(View paramView) {
    if (b.XB()) {
      Intent intent = new Intent(this.dmx.getActivity(), com.laiqian.scanorder.settings.ScanOrderSettingActivity.class);
      this.dmx.startActivity(intent);
      return;
    } 
    r r = new r(this.dmx.getActivity(), new bw(this));
    r.oZ(this.dmx.getString(2131625905));
    r.t(this.dmx.getString(2131629880));
    r.s(this.dmx.getString(2131625992));
    r.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */