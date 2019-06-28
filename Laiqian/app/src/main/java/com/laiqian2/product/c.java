package com.laiqian.product;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class c extends WebChromeClient {
  c(Mall paramMall) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    super.onProgressChanged(paramWebView, paramInt);
    if (paramInt < 100 && (Mall.b(this.cOI) || (Mall.c(this.cOI) && paramInt > 0))) {
      Mall.d(this.cOI).setVisibility(0);
      return;
    } 
    Mall.d(this.cOI).setVisibility(8);
    Mall.c(this.cOI, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */