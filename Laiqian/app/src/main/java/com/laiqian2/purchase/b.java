package com.laiqian.purchase;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.laiqian.pos.industry.b;
import com.laiqian.util.n;

class b extends WebViewClient {
  b(PurchaseActivity paramPurchaseActivity) {}
  
  public void onPageCommitVisible(WebView paramWebView, String paramString) {
    super.onPageCommitVisible(paramWebView, paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是onPageCommitVisible,:");
    stringBuilder.append(paramString);
    n.println(stringBuilder.toString());
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    super.onPageFinished(paramWebView, paramString);
    if (paramString.startsWith(b.crx)) {
      PurchaseActivity.c(this.cXQ).setVisibility(0);
      return;
    } 
    PurchaseActivity.c(this.cXQ).setVisibility(8);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\purchase\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */