package com.laiqian.pos.industry.weiorder;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.laiqian.basic.RootApplication;

class aa implements CompoundButton.OnCheckedChangeListener {
  aa(QrorderMarketingFragment paramQrorderMarketingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramBoolean && !RootApplication.getLaiqianPreferenceManager().Wq()) {
      ((CheckBox)this.csM.csK.csW.dwV.getView()).setChecked(false);
      QrorderMarketingFragment.b(this.csM).show();
      return;
    } 
    this.csM.csL.eY(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */