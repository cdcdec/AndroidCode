package com.laiqian.pos.industry.weiorder;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;

class ab implements CompoundButton.OnCheckedChangeListener {
  ab(QrorderMarketingFragment paramQrorderMarketingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (!paramBoolean) {
      if (!((CheckBox)this.csM.csK.csR.dwV.getView()).isChecked()) {
        ((CheckBox)this.csM.csK.csU.dwV.getView()).setChecked(true);
        this.csM.showError(this.csM.getString(2131630554));
        return;
      } 
      this.csM.csL.eZ(paramBoolean);
      return;
    } 
    if (TextUtils.isEmpty(this.csM.csL.abe())) {
      if (this.csM.getLaiqianPreferenceManager().avM()) {
        this.csM.csL.abg();
      } else {
        this.csM.showError(this.csM.getString(2131627144));
      } 
      ((CheckBox)this.csM.csK.csU.dwV.getView()).setChecked(false);
      return;
    } 
    this.csM.csL.eZ(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */