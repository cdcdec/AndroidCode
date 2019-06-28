package com.laiqian.pos.industry.weiorder;

import com.laiqian.pos.dw;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class dy implements w.a {
  dy(WeshopBindingFragment paramWeshopBindingFragment) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        WeshopBindingFragment.d(this.cvz);
        return;
      case 0:
        break;
    } 
    WeshopBindingFragment.a(this.cvz, dw.aT(this.cvz.getActivity()));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */