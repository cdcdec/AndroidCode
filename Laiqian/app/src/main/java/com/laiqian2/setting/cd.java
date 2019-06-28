package com.laiqian.setting;

import android.content.Intent;
import android.view.View;

class cd implements View.OnClickListener {
  cd(SettingProductFragment paramSettingProductFragment) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.dmQ.getActivity(), com.laiqian.product.ProductTaxRuleActivity.class);
    this.dmQ.startActivityForResult(intent, 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */