package com.laiqian.ui.webview;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class i extends WebChromeClient {
  i(SimpleWebViewActivity paramSimpleWebViewActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    if (paramInt >= 100) {
      SimpleWebViewActivity.a(this.dEn).setVisibility(8);
      return;
    } 
    SimpleWebViewActivity.a(this.dEn).setVisibility(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\webview\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */