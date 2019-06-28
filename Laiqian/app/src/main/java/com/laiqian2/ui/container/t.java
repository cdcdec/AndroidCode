package com.laiqian.ui.container;

import android.util.Pair;
import android.view.View;
import com.laiqian.d.a;

class t implements View.OnClickListener {
  t(LayoutLeftTextRightLabelWithAddButton paramLayoutLeftTextRightLabelWithAddButton) {}
  
  public void onClick(View paramView) {
    LayoutLeftTextRightLabelWithAddButton.a(this.dxu).performClick();
    LayoutLeftTextRightLabelWithAddButton.a(this.dxu).setVisibility(8);
    a.AZ().bX("");
    if (LayoutLeftTextRightLabelWithAddButton.c(this.dxu) != null)
      LayoutLeftTextRightLabelWithAddButton.c(this.dxu).d(new Pair(Double.valueOf(0.0D), Double.valueOf(0.0D))); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */