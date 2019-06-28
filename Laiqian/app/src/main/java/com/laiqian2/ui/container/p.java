package com.laiqian.ui.container;

import android.view.View;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.at;

class p implements View.OnClickListener {
  p(LayoutLeftTextRightLabelWithAddButton paramLayoutLeftTextRightLabelWithAddButton) {}
  
  public void onClick(View paramView) {
    if (LayoutLeftTextRightLabelWithAddButton.a(this.dxu).getVisibility() == 0) {
      Toast.makeText(LayoutLeftTextRightLabelWithAddButton.b(this.dxu), R.string.only_one_code_available, 0).show();
      return;
    } 
    at at = new at(LayoutLeftTextRightLabelWithAddButton.b(this.dxu));
    at.kW(R.string.key_in_discount_number);
    at.kV(R.string.lqj_cancel);
    at.kU(R.string.verify);
    at.setCanceledOnTouchOutside(false);
    at.a(new q(this, at));
    at.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */