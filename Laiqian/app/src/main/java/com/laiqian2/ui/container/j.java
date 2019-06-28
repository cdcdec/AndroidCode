package com.laiqian.ui.container;

import android.support.v7.widget.AppCompatRadioButton;
import android.widget.CompoundButton;

class j implements CompoundButton.OnCheckedChangeListener {
  j(i parami) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    ((AppCompatRadioButton)this.dwU.dwS.getView()).setChecked(paramBoolean ^ true);
    if (this.dwU.dwT != null)
      this.dwU.dwT.onCheckedChanged(paramCompoundButton, paramBoolean); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */