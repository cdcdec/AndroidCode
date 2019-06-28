package com.laiqian.setting;

import android.view.View;
import android.widget.TextView;
import com.laiqian.ui.a.ax;

class bt implements View.OnClickListener {
  bt(SettingDecimals paramSettingDecimals) {}
  
  public void onClick(View paramView) {
    if (SettingDecimals.a(this.dme) == null) {
      SettingDecimals.a(this.dme, new ax(this.dme.getActivity(), SettingDecimals.b(this.dme), new bu(this)));
      SettingDecimals.a(this.dme).b((TextView)paramView.getTag(), -1);
      SettingDecimals.a(this.dme).setTitle(2131626532);
    } 
    SettingDecimals.a(this.dme).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */