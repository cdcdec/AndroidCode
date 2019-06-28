package com.laiqian.pos.industry.weiorder;

import android.widget.CheckBox;
import android.widget.CompoundButton;

class o implements CompoundButton.OnCheckedChangeListener {
  o(QrorderMarketingFragment paramQrorderMarketingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (!paramBoolean) {
      if (!((CheckBox)this.csM.csK.csU.dwV.getView()).isChecked()) {
        ((CheckBox)this.csM.csK.csR.dwV.getView()).setChecked(true);
        this.csM.showError(this.csM.getString(2131630554));
        return;
      } 
      this.csM.csL.cF(paramBoolean);
      return;
    } 
    this.csM.csL.cF(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */