package com.laiqian.eleme;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class c extends WebViewClient {
  c(ElemeActivity paramElemeActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) { super.onPageFinished(paramWebView, paramString); }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    this.aQF.aQz.aQH.setVisibility(8);
    Log.e("description", paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    Log.e("errorCode", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("");
    Log.e("failingUrl", stringBuilder.toString());
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) { return true; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\eleme\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */