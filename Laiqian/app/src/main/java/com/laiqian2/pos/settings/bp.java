package com.laiqian.pos.settings;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.d.a.b.a.b;
import com.d.a.b.f.a;
import com.laiqian.ui.ProgressBarCircularIndeterminate;

class bp implements a {
  bp(ShopInfoActivity paramShopInfoActivity) {}
  
  public void a(String paramString, View paramView, Bitmap paramBitmap) {
    ((ProgressBarCircularIndeterminate)this.cBl.cBh.cAC.getView()).setVisibility(8);
    ((ImageView)this.cBl.cBh.cAB.getView()).setVisibility(0);
    ((ImageView)this.cBl.cBh.cAD.getView()).setVisibility(8);
  }
  
  public void a(String paramString, View paramView, b paramb) {
    ((ProgressBarCircularIndeterminate)this.cBl.cBh.cAC.getView()).setVisibility(8);
    ((ImageView)this.cBl.cBh.cAB.getView()).setVisibility(8);
    ((ImageView)this.cBl.cBh.cAD.getView()).setVisibility(0);
  }
  
  public void e(String paramString, View paramView) {}
  
  public void f(String paramString, View paramView) {
    ((ProgressBarCircularIndeterminate)this.cBl.cBh.cAC.getView()).setVisibility(0);
    ((ImageView)this.cBl.cBh.cAB.getView()).setVisibility(8);
    ((ImageView)this.cBl.cBh.cAD.getView()).setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */