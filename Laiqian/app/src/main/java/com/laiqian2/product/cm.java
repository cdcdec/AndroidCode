package com.laiqian.product;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class cm implements w.a {
  cm(cl paramcl) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    ck.a(this.cRm.cRl, paramInt);
    ck.a(this.cRm.cRl, ck.d(this.cRm.cRl)[paramInt]);
    ck.e(this.cRm.cRl).setText(ck.b(this.cRm.cRl)[paramInt]);
    if (ck.f(this.cRm.cRl)[paramInt]) {
      ck.a(this.cRm.cRl, ck.g(this.cRm.cRl));
      return;
    } 
    ViewParent viewParent = ck.g(this.cRm.cRl).getParent();
    if (viewParent != null) {
      ((ViewGroup)viewParent).removeView(ck.g(this.cRm.cRl));
      ck.h(this.cRm.cRl).setText("");
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */