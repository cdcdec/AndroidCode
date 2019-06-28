package com.laiqian.binding;

import com.laiqian.basic.RootApplication;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.webview.SimpleWebViewActivity;
import com.laiqian.util.n;
import com.laiqian.wallet.R;

public class BindingWechatHelp extends SimpleWebViewActivity {
  protected String zG() { return getString(R.string.wechat_payment_binding); }
  
  protected String zH() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.cmp);
    stringBuilder.append("?shop_id=");
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().Tx());
    String str = stringBuilder.toString();
    n.C(getApplicationContext(), str);
    return str;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\binding\BindingWechatHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */