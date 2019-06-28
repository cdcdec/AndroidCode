package com.laiqian.ordertool.smartorder;

import android.content.Intent;
import android.view.View;

class k implements View.OnClickListener {
  k(SmartOrderSettingsFragment paramSmartOrderSettingsFragment) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent();
    intent.setClass(this.ceO.getActivity(), com.laiqian.ordertool.IPhoneIntro.class);
    this.ceO.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\smartorder\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */