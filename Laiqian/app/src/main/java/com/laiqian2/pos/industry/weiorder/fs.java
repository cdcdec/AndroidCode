package com.laiqian.pos.industry.weiorder;

import android.text.Editable;
import com.google.a.a.a.a.a.a;
import com.laiqian.ui.r;

class fs extends r {
  fs(WeshopMarketingFragment paramWeshopMarketingFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {
    try {
      double d = Double.parseDouble(paramEditable.toString());
      this.cwC.cww.aE(d);
      return;
    } catch (Exception paramEditable) {
      a.e(paramEditable);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */