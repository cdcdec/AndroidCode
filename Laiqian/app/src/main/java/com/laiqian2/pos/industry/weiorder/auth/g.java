package com.laiqian.pos.industry.weiorder.auth;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class g extends WebViewClient {
  g(WechatAutoActivity paramWechatAutoActivity) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) { WechatAutoActivity.a(this.cyd).setVisibility(8); }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) { return false; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\auth\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */