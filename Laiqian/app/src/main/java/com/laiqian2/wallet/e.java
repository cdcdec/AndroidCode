package com.laiqian.wallet;

import android.view.View;
import com.laiqian.util.n;

class e implements View.OnClickListener {
  e(BindingAlipay paramBindingAlipay) {}
  
  public void onClick(View paramView) {
    if (BindingAlipay.i(this.dKY).getVisibility() == 0) {
      n.w(this.dKY, R.string.pos_wallet_reflect_binding_executing_noWorry);
      return;
    } 
    BindingAlipay.i(this.dKY).setVisibility(0);
    BindingAlipay.j(this.dKY).setVisibility(8);
    (new f(this)).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */