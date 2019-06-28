package com.laiqian.setting;

import android.view.View;
import android.widget.TextView;
import com.laiqian.ui.a.ax;

class ce implements View.OnClickListener {
  ce(SettingProductFragment paramSettingProductFragment) {}
  
  public void onClick(View paramView) {
    if (SettingProductFragment.a(this.dmQ) == null) {
      SettingProductFragment.a(this.dmQ, new ax(this.dmQ.getActivity(), 2130903071, new cf(this)));
      SettingProductFragment.a(this.dmQ).b((TextView)paramView.getTag(), -1);
    } 
    SettingProductFragment.a(this.dmQ).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */