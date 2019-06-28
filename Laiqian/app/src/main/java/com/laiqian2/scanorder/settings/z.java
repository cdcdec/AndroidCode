package com.laiqian.scanorder.settings;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.laiqian.basic.RootApplication;

class z implements CompoundButton.OnCheckedChangeListener {
  z(PayAndFeeFragment paramPayAndFeeFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramBoolean && !RootApplication.getLaiqianPreferenceManager().Wq()) {
      ((CheckBox)this.djj.djg.csW.dwV.getView()).setChecked(false);
      PayAndFeeFragment.b(this.djj).show();
      return;
    } 
    this.djj.djh.cE(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */