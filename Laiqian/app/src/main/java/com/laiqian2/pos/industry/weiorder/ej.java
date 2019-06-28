package com.laiqian.pos.industry.weiorder;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

class ej implements View.OnClickListener {
  ej(ei paramei) {}
  
  public void onClick(View paramView) {
    if (TextUtils.isEmpty(this.cvF.cso.getText())) {
      Toast.makeText(this.cvF.getContext(), this.cvF.getContext().getString(2131630536), 0).show();
      return;
    } 
    if (TextUtils.isEmpty(this.cvF.etDiscount.getText())) {
      Toast.makeText(this.cvF.getContext(), this.cvF.getContext().getString(2131630532), 0).show();
      return;
    } 
    try {
      double d1 = Double.parseDouble(this.cvF.cso.getText().toString());
      double d2 = Double.parseDouble(this.cvF.etDiscount.getText().toString());
      if (this.cvF.cvE != null)
        this.cvF.cvE.a(this.cvF, d1, d2); 
      return;
    } catch (Exception paramView) {
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */