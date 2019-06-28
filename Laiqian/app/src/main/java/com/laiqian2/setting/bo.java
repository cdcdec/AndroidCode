package com.laiqian.setting;

import android.content.Context;
import android.view.View;
import com.laiqian.d.a;
import com.laiqian.ui.a.r;
import com.laiqian.util.m;

class bo extends m.b {
  bo(SettingCashierFragment paramSettingCashierFragment, Context paramContext, View paramView) { super(paramContext, paramView); }
  
  protected void f(View paramView1, View paramView2) {
    a.AZ().bL(paramView2.isSelected());
    if (paramView2.isSelected()) {
      if (SettingCashierFragment.e(this.dlV) == null) {
        SettingCashierFragment.a(this.dlV, new r(this.dlV.getActivity(), 3, null));
        SettingCashierFragment.e(this.dlV).setTitle(this.dlV.getString(2131627480));
        SettingCashierFragment.e(this.dlV).s(this.dlV.getString(2131627478));
        SettingCashierFragment.e(this.dlV).pa(this.dlV.getString(2131627479));
        SettingCashierFragment.e(this.dlV).setWidth((this.dlV.getResources().getDisplayMetrics()).widthPixels / 3);
      } 
      SettingCashierFragment.e(this.dlV).show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */