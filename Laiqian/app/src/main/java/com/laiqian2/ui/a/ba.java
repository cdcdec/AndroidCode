package com.laiqian.ui.a;

import android.view.View;

class ba implements View.OnClickListener {
  ba(az paramaz) {}
  
  public void onClick(View paramView) {
    az.a(this.dAL).clearFocus();
    int i = az.a(this.dAL).getCurrentHour().intValue();
    int j = az.a(this.dAL).getCurrentMinute().intValue();
    if (az.b(this.dAL) != null && az.b(this.dAL).a(az.c(this.dAL), i, j))
      return; 
    this.dAL.cancel();
    if (az.b(this.dAL) != null)
      az.b(this.dAL).b(az.c(this.dAL), i, j); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */