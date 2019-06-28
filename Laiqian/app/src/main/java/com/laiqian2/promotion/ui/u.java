package com.laiqian.promotion.ui;

import android.support.v7.widget.AppCompatRadioButton;
import android.text.Editable;
import com.laiqian.promotion.d.a;
import com.laiqian.ui.r;
import com.laiqian.util.n;

class u extends r {
  u(PromotionCreateActivity paramPromotionCreateActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (PromotionCreateActivity.h(this.cWA) == 3) {
      if (((AppCompatRadioButton)this.cWA.cWe.cXN.dwR.getView()).isChecked()) {
        PromotionCreateActivity.c(this.cWA).eB(0);
        PromotionCreateActivity.c(this.cWA).mU(paramEditable.toString().trim());
        return;
      } 
      PromotionCreateActivity.c(this.cWA).eB(1);
      PromotionCreateActivity.c(this.cWA).mV(paramEditable.toString().trim());
      return;
    } 
    double d2 = n.u(paramEditable.toString().trim());
    a a = PromotionCreateActivity.c(this.cWA);
    double d1 = d2;
    if (PromotionCreateActivity.i(this.cWA))
      d1 = 100.0D - d2; 
    a.p(d1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\u\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */