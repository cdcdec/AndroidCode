package com.laiqian.promotion.ui;

import android.text.Editable;
import com.laiqian.ui.r;

class t extends r {
  t(PromotionCreateActivity paramPromotionCreateActivity) {}
  
  public void afterTextChanged(Editable paramEditable) { PromotionCreateActivity.c(this.cWA).mT(paramEditable.toString().trim()); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */