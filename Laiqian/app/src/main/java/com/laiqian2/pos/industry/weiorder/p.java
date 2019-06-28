package com.laiqian.pos.industry.weiorder;

import android.widget.CheckBox;
import android.widget.CompoundButton;

class p implements CompoundButton.OnCheckedChangeListener {
  p(QrorderMarketingFragment paramQrorderMarketingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (!paramBoolean) {
      if (!((CheckBox)this.csM.csK.csV.dwV.getView()).isChecked()) {
        ((CheckBox)this.csM.csK.csS.dwV.getView()).setChecked(true);
        this.csM.showError(this.csM.getString(2131630554));
        return;
      } 
      this.csM.csL.cG(paramBoolean);
      return;
    } 
    this.csM.csL.cG(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */