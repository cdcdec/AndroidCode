package com.laiqian.ui.container;

import android.support.v7.widget.AppCompatRadioButton;
import android.widget.CompoundButton;

class k implements CompoundButton.OnCheckedChangeListener {
  k(i parami) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    ((AppCompatRadioButton)this.dwU.dwR.getView()).setChecked(paramBoolean ^ true);
    if (this.dwU.dwT != null)
      this.dwU.dwT.onCheckedChanged(paramCompoundButton, paramBoolean); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */