package com.laiqian.binding;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.laiqian.basic.RootApplication;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.wallet.R;

public class BindingAlipayHelp extends ActivityRoot {
  private WebView aIZ;
  
  private View aJa;
  
  private View[] aJb;
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.pos_paytype_setting_binding_alipay_help);
    setTitleTextViewHideRightView(R.string.pos_paytype_binding_alipay_title);
    this.aJa = findViewById(R.id.loading);
    this.aIZ = (WebView)findViewById(R.id.webview);
    int i = Build.VERSION.SDK_INT;
    this.aIZ.setWebViewClient(new a(this));
    this.aIZ.setWebChromeClient(new b(this));
    this.aIZ.getSettings().setJavaScriptEnabled(true);
    c c = new c(this);
    View view1 = findViewById(R.id.sign);
    view1.setTag(RootUrlParameter.cmt);
    view1.setOnClickListener(c);
    View view2 = findViewById(R.id.bind);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.cmw);
    stringBuilder.append("?shopid=");
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().Tx());
    view2.setTag(stringBuilder.toString());
    view2.setOnClickListener(c);
    View view3 = findViewById(R.id.publickey);
    view3.setTag(RootUrlParameter.cmv);
    view3.setOnClickListener(c);
    this.aJb = new View[] { view1, view2, view3 };
    performClick(view1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\binding\BindingAlipayHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */