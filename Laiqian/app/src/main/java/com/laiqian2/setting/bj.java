package com.laiqian.setting;

import android.view.View;
import android.widget.TextView;
import com.laiqian.ui.a.ax;

class bj implements View.OnClickListener {
  bj(SettingCashierFragment paramSettingCashierFragment) {}
  
  public void onClick(View paramView) {
    if (SettingCashierFragment.a(this.dlV) == null) {
      SettingCashierFragment.a(this.dlV, new ax(this.dlV.getActivity(), SettingCashierFragment.b(this.dlV), new bk(this)));
      SettingCashierFragment.a(this.dlV).b((TextView)paramView.getTag(), -1);
      SettingCashierFragment.a(this.dlV).setTitle(2131626535);
    } 
    SettingCashierFragment.a(this.dlV).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */