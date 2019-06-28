package com.laiqian.pos.industry.weiorder;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class bn extends WebViewClient {
  bn(TddSetting paramTddSetting) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) { this.ctU.ctN.setVisibility(8); }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    if (paramString.contains("#access_token=")) {
      TddSetting.a(this.ctU, paramString);
      TddSetting.b(this.ctU);
    } 
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */