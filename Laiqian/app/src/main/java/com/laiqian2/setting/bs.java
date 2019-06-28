package com.laiqian.setting;

import android.view.View;
import com.laiqian.d.a;
import com.laiqian.ui.a.r;

class bs implements View.OnClickListener {
  bs(SettingDecimals paramSettingDecimals) {}
  
  public void onClick(View paramView) {
    paramView.setSelected(paramView.isSelected() ^ true);
    SettingDecimals.a(this.dme, paramView.isSelected());
    a.AZ().bW(paramView.isSelected());
    if (paramView.isSelected()) {
      r r = new r(this.dme.getActivity(), 3, null);
      r.setTitle(this.dme.getString(2131626722));
      r.s(this.dme.getString(2131626531));
      r.pa(this.dme.getString(2131626714));
      r.show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */