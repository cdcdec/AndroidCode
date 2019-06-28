package com.laiqian.scanorder.settings;

import com.laiqian.scan_order_module.R;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class m implements w.a {
  m(l paraml) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        this.diO.diN.diK.setText(R.string.charge_by_number);
        this.diO.diN.diK.setTag(Integer.valueOf(1));
        return;
      case 0:
        break;
    } 
    this.diO.diN.diK.setText(R.string.fixed_amount);
    this.diO.diN.diK.setTag(Integer.valueOf(0));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */