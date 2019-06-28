package com.laiqian.pos.industry.weiorder;

import android.widget.CheckBox;
import android.widget.CompoundButton;

class gf implements CompoundButton.OnCheckedChangeListener {
  gf(WeshopMarketingFragment paramWeshopMarketingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (!paramBoolean) {
      if (!this.cwC.cwx || !((CheckBox)this.cwC.cwv.cwM.dwV.getView()).isChecked()) {
        ((CheckBox)this.cwC.cwv.cwN.dwV.getView()).setChecked(true);
        this.cwC.showError(this.cwC.getString(2131630554));
        return;
      } 
      this.cwC.cww.ft(paramBoolean);
      return;
    } 
    this.cwC.cww.ft(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */