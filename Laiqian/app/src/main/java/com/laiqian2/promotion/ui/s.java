package com.laiqian.promotion.ui;

import android.widget.CompoundButton;
import com.laiqian.promotion.R;
import com.laiqian.ui.container.i;

class s implements i.a {
  s(PromotionCreateActivity paramPromotionCreateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramCompoundButton.getId() == R.id.apb_left_radio) {
      PromotionCreateActivity.b(this.cWA, paramBoolean ^ true);
      return;
    } 
    if (paramCompoundButton.getId() == R.id.apb_right_radio)
      PromotionCreateActivity.b(this.cWA, paramBoolean); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */