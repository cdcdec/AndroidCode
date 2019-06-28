package com.laiqian.meituan;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class c extends WebViewClient {
  c(MTSettingActivity paramMTSettingActivity) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) { this.bpJ.bpD.aQH.setVisibility(8); }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    if (paramString.contains("access_token")) {
      String str = paramString.substring(paramString.indexOf("="));
      Log.e("access_token", paramString);
      Log.e("access_token", str);
      this.bpJ.bpE.fk(str);
      this.bpJ.bpE.init();
      this.bpJ.Eo();
    } 
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */