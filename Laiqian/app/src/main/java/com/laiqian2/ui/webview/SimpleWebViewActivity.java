package com.laiqian.ui.webview;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ActivityRoot;
import com.umeng.analytics.MobclickAgent;

public class SimpleWebViewActivity extends ActivityRoot {
  private WebView aIZ;
  
  private View aJa;
  
  protected void a(WebView paramWebView) {}
  
  protected String ast() { return getIntent().getStringExtra("html"); }
  
  protected String asu() { return getIntent().getStringExtra("dst_activity"); }
  
  public void onBackPressed() {
    if (this.aIZ.canGoBack()) {
      this.aIZ.goBack();
      return;
    } 
    if (TextUtils.isEmpty(asu())) {
      super.onBackPressed();
      return;
    } 
    try {
      startActivity(new Intent(this, Class.forName(asu())));
      return;
    } catch (ClassNotFoundException classNotFoundException) {
      a.e(classNotFoundException);
      return;
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.pos_simple_webview);
    setTitleTextViewHideRightView(zG());
    this.aJa = findViewById(R.id.loading);
    this.aIZ = (WebView)findViewById(R.id.webview);
    if (TextUtils.isEmpty(ast())) {
      this.aIZ.loadUrl(zH());
    } else {
      this.aIZ.loadDataWithBaseURL(null, ast(), "text/html", "utf-8", null);
      this.aIZ.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    } 
    int i = Build.VERSION.SDK_INT;
    this.aIZ.setWebViewClient(new h(this));
    this.aIZ.setWebChromeClient(new i(this));
    this.aIZ.getSettings().setJavaScriptEnabled(true);
    this.aIZ.addJavascriptInterface(this, "registerAccountPaySuccess");
    a(this.aIZ);
  }
  
  @JavascriptInterface
  public void registerAccountPaySuccess() { MobclickAgent.onEvent(this, "register_pay_success"); }
  
  protected String zG() { return getIntent().getStringExtra("title"); }
  
  protected String zH() { return getIntent().getStringExtra("url"); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\webview\SimpleWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */