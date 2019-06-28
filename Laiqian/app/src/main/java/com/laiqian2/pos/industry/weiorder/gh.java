package com.laiqian.pos.industry.weiorder;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.laiqian.c.a;

class gh implements CompoundButton.OnCheckedChangeListener {
  gh(WeshopMarketingFragment paramWeshopMarketingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (!paramBoolean) {
      if (!((CheckBox)this.cwC.cwv.cwN.dwV.getView()).isChecked()) {
        ((CheckBox)this.cwC.cwv.cwM.dwV.getView()).setChecked(true);
        this.cwC.showError(this.cwC.getString(2131630554));
        return;
      } 
      this.cwC.cww.cJ(paramBoolean);
      return;
    } 
    if (TextUtils.isEmpty(this.cwC.cww.abf()) && !a.zR().Ab()) {
      this.cwC.cww.abh();
      ((CheckBox)this.cwC.cwv.cwM.dwV.getView()).setChecked(false);
      return;
    } 
    this.cwC.cww.cJ(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */