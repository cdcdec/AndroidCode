package com.laiqian.pos;

import android.text.Editable;
import android.text.TextUtils;
import com.laiqian.ui.r;

class cr extends r {
  cr(ReprintActivity paramReprintActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (!TextUtils.isEmpty(paramEditable)) {
      (ReprintActivity.b(this.cik)).cio.setVisibility(0);
      ReprintActivity.a(this.cik, paramEditable.toString());
      ReprintActivity.a(this.cik, ReprintActivity.c(this.cik), ReprintActivity.d(this.cik));
      return;
    } 
    (ReprintActivity.b(this.cik)).cio.setVisibility(8);
    ReprintActivity.a(this.cik, "");
    ReprintActivity.a(this.cik, ReprintActivity.c(this.cik), null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */