package com.laiqian.setting;

import android.view.View;
import android.widget.TextView;
import com.laiqian.ui.a.ax;

class bm implements View.OnClickListener {
  bm(SettingCashierFragment paramSettingCashierFragment) {}
  
  public void onClick(View paramView) {
    if (SettingCashierFragment.d(this.dlV) == null) {
      SettingCashierFragment.b(this.dlV, new ax(this.dlV.getActivity(), 2130903071, new bn(this)));
      SettingCashierFragment.d(this.dlV).b((TextView)paramView.getTag(), -1);
    } 
    SettingCashierFragment.d(this.dlV).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */