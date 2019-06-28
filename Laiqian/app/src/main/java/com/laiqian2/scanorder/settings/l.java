package com.laiqian.scanorder.settings;

import android.content.Context;
import android.view.View;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.a.w;
import com.laiqian.util.n;

class l implements View.OnClickListener {
  l(f paramf) {}
  
  public void onClick(View paramView) {
    if (this.diN.cTc == null) {
      f f1 = this.diN;
      Context context = this.diN.getContext();
      String str1 = this.diN.getContext().getString(R.string.fixed_amount);
      String str2 = this.diN.getContext().getString(R.string.charge_by_number);
      m m = new m(this);
      f1.cTc = new w(context, new String[] { str1, str2 }, m);
    } 
    this.diN.cTc.gn(n.parseInt(String.valueOf(this.diN.diK.getTag())));
    this.diN.cTc.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */