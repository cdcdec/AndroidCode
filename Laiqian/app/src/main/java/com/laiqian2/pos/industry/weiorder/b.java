package com.laiqian.pos.industry.weiorder;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

class b implements View.OnClickListener {
  b(a parama) {}
  
  public void onClick(View paramView) {
    if (TextUtils.isEmpty(this.csu.cso.getText())) {
      Toast.makeText(this.csu.getContext(), this.csu.getContext().getString(2131625057), 0).show();
      return;
    } 
    try {
      double d = Double.parseDouble(this.csu.cso.getText().toString());
      String str = this.csu.etDiscount.getText().toString();
      if (this.csu.cst != null) {
        a.a a1 = this.csu.cst;
        a a2 = this.csu;
        if (!TextUtils.isEmpty(this.csu.etDiscount.getHint()))
          str = this.csu.etDiscount.getHint().toString(); 
        a1.a(a2, d, str);
      } 
      return;
    } catch (Exception paramView) {
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */