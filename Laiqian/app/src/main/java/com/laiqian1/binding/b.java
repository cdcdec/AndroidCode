package com.laiqian.binding;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class b extends WebChromeClient {
  b(BindingAlipayHelp paramBindingAlipayHelp) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    if (paramInt >= 100) {
      BindingAlipayHelp.a(this.aJc).setVisibility(8);
      return;
    } 
    BindingAlipayHelp.a(this.aJc).setVisibility(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\binding\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */