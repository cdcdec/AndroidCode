package com.laiqian.pos.industry.weiorder;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.laiqian.basic.RootApplication;

class gg implements CompoundButton.OnCheckedChangeListener {
  gg(WeshopMarketingFragment paramWeshopMarketingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramBoolean && !RootApplication.getLaiqianPreferenceManager().Wq()) {
      WeshopMarketingFragment.b(this.cwC).show();
      ((CheckBox)this.cwC.cwv.cwO.dwV.getView()).setChecked(false);
      return;
    } 
    this.cwC.cww.cE(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */