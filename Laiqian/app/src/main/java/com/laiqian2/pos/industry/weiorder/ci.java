package com.laiqian.pos.industry.weiorder;

import com.laiqian.pos.dw;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class ci implements w.a {
  ci(WeChatWeshopBindingActivity paramWeChatWeshopBindingActivity) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        WeChatWeshopBindingActivity.e(this.cuf);
        return;
      case 0:
        break;
    } 
    WeChatWeshopBindingActivity.a(this.cuf, dw.aT(this.cuf.getActivity()));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */