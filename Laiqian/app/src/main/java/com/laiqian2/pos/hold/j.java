package com.laiqian.pos.hold;

import com.laiqian.d.a;
import com.laiqian.models.at;
import com.laiqian.ui.ImageCheckBox;

class j implements ImageCheckBox.a {
  j(HolderOpenTableSettingFragment paramHolderOpenTableSettingFragment) {}
  
  public void a(ImageCheckBox paramImageCheckBox, boolean paramBoolean) {
    a.AZ().bH(paramBoolean);
    if (paramBoolean && !HolderOpenTableSettingFragment.c(this.cnQ).isSelected()) {
      HolderOpenTableSettingFragment.c(this.cnQ).setSelected(true);
      at at = new at(this.cnQ.getActivity());
      at.en(true);
      at.close();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */