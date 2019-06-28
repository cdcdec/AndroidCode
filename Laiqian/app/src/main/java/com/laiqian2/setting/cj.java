package com.laiqian.setting;

import android.content.Context;
import android.view.View;
import com.laiqian.d.a;
import com.laiqian.ui.a.r;
import com.laiqian.util.m;

class cj extends m.b {
  cj(SettingProductFragment paramSettingProductFragment, Context paramContext, View paramView) { super(paramContext, paramView); }
  
  protected void f(View paramView1, View paramView2) {
    a.AZ().bL(paramView2.isSelected());
    if (paramView2.isSelected()) {
      if (SettingProductFragment.e(this.dmQ) == null) {
        SettingProductFragment.a(this.dmQ, new r(this.dmQ.getActivity(), 3, null));
        SettingProductFragment.e(this.dmQ).setTitle(this.dmQ.getString(2131627480));
        SettingProductFragment.e(this.dmQ).s(this.dmQ.getString(2131627478));
        SettingProductFragment.e(this.dmQ).pa(this.dmQ.getString(2131627479));
        SettingProductFragment.e(this.dmQ).setWidth((this.dmQ.getResources().getDisplayMetrics()).widthPixels / 3);
      } 
      SettingProductFragment.e(this.dmQ).show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */