package com.laiqian.pos.industry.weiorder;

import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.ui.a.w;

class fu implements View.OnClickListener {
  fu(WeshopMarketingFragment paramWeshopMarketingFragment) {}
  
  public void onClick(View paramView) {
    try {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "20";
      arrayOfString[1] = "40";
      arrayOfString[2] = "60";
      (new w(this.cwC.getActivity(), arrayOfString, new fv(this, arrayOfString))).show();
      return;
    } catch (Exception paramView) {
      a.e(paramView);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */