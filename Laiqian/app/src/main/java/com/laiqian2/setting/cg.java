package com.laiqian.setting;

import android.view.View;
import android.widget.TextView;
import com.laiqian.ui.a.ax;

class cg implements View.OnClickListener {
  cg(SettingProductFragment paramSettingProductFragment) {}
  
  public void onClick(View paramView) {
    if (SettingProductFragment.b(this.dmQ) == null) {
      SettingProductFragment.b(this.dmQ, new ax(this.dmQ.getActivity(), SettingProductFragment.c(this.dmQ), new ch(this)));
      SettingProductFragment.b(this.dmQ).b((TextView)paramView.getTag(), -1);
      SettingProductFragment.b(this.dmQ).setTitle(2131626535);
    } 
    SettingProductFragment.b(this.dmQ).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */