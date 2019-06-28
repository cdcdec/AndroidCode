package com.laiqian.meituan;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class m extends WebViewClient {
  m(MeituanActivity paramMeituanActivity) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) { this.bqa.bpW.aQH.setVisibility(8); }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    Log.e("跳转sUrl", paramString);
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */