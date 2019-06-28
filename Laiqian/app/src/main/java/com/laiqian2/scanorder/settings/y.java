package com.laiqian.scanorder.settings;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.laiqian.scan_order_module.R;

class y implements CompoundButton.OnCheckedChangeListener {
  y(PayAndFeeFragment paramPayAndFeeFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramBoolean) {
      if (TextUtils.isEmpty(this.djj.djh.abf())) {
        if (this.djj.getLaiqianPreferenceManager().avM()) {
          this.djj.djh.abh();
        } else {
          this.djj.showError(this.djj.getString(R.string.pos_no_access_no_boss));
        } 
        ((CheckBox)this.djj.djg.csV.dwV.getView()).setChecked(false);
        return;
      } 
      this.djj.djh.fa(paramBoolean);
      return;
    } 
    this.djj.djh.fa(paramBoolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */