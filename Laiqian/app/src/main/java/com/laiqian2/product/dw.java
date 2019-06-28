package com.laiqian.product;

import android.view.View;
import com.laiqian.ui.a.w;

class dw implements View.OnClickListener {
  dw(ProductTaxRuleEditActivity paramProductTaxRuleEditActivity) {}
  
  public void onClick(View paramView) {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.cSG.getResources().getString(2131627630);
    arrayOfString[1] = this.cSG.getResources().getString(2131627631);
    (new w(this.cSG.getActivity(), arrayOfString, new dx(this, arrayOfString))).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */