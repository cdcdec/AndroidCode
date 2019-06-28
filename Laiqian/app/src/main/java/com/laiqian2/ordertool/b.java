package com.laiqian.ordertool;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class b extends WebViewClient {
  b(IPhoneIntro paramIPhoneIntro) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */