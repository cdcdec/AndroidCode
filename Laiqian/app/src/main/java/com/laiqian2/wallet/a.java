package com.laiqian.wallet;

import android.view.View;
import com.laiqian.util.n;

class a implements View.OnClickListener {
  a(BindingAlipay paramBindingAlipay) {}
  
  public void onClick(View paramView) {
    if (BindingAlipay.a(this.dKY).getVisibility() == 0) {
      n.w(this.dKY, R.string.pos_wallet_reflect_verification_executing_noWorry);
      return;
    } 
    BindingAlipay.a(this.dKY).setVisibility(0);
    BindingAlipay.b(this.dKY).setText(R.string.pos_wallet_reflect_verification_executing);
    (new b(this)).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */