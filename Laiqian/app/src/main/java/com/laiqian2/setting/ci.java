package com.laiqian.setting;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.laiqian.d.a;
import com.laiqian.util.m;

class ci extends m.b {
  ci(SettingProductFragment paramSettingProductFragment, Context paramContext, View paramView) { super(paramContext, paramView); }
  
  protected void f(View paramView1, View paramView2) {
    a.AZ().bS(paramView2.isSelected());
    if (paramView2.isSelected())
      SettingProductFragment.d(this.dmQ); 
    this.dmQ.getActivity().sendBroadcast(new Intent("pos_activity_change_data_product"));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */