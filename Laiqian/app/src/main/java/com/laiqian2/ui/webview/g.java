package com.laiqian.ui.webview;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.bb;

class g extends WebViewClient {
  g(SimplePosWebViewLinearLayout paramSimplePosWebViewLinearLayout) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    if (!SimplePosWebViewLinearLayout.a(this.dEm))
      return; 
    if (SimplePosWebViewLinearLayout.c(this.dEm))
      this.dEm.asq(); 
    if (SimplePosWebViewLinearLayout.b(this.dEm) != null)
      SimplePosWebViewLinearLayout.b(this.dEm).onPageFinished(paramWebView, paramString); 
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    if (!SimplePosWebViewLinearLayout.a(this.dEm))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append(paramString1);
    stringBuilder.append(paramString2);
    bb.e("webViewError", stringBuilder.toString());
    if (SimplePosWebViewLinearLayout.b(this.dEm) != null)
      SimplePosWebViewLinearLayout.b(this.dEm).onReceivedError(paramWebView, paramInt, paramString1, paramString2); 
    if (paramInt != -1) {
      SimplePosWebViewLinearLayout simplePosWebViewLinearLayout = this.dEm;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("错误代码：");
      stringBuilder1.append(paramInt);
      stringBuilder1.append(",错误描述：");
      stringBuilder1.append(paramString1);
      stringBuilder1.append(" 请刷新或联系客服。");
      SimplePosWebViewLinearLayout.a(simplePosWebViewLinearLayout, stringBuilder1.toString());
    } 
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    if (!SimplePosWebViewLinearLayout.a(this.dEm))
      return; 
    paramSslErrorHandler.proceed();
    this.dEm.dEd.setVisibility(8);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    if (SimplePosWebViewLinearLayout.a(this.dEm)) {
      if (SimplePosWebViewLinearLayout.b(this.dEm) != null)
        SimplePosWebViewLinearLayout.b(this.dEm).shouldOverrideUrlLoading(paramWebView, paramString); 
      if (paramString.startsWith("tel:")) {
        try {
          Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(paramString));
          SimplePosWebViewLinearLayout.d(this.dEm).startActivity(intent);
        } catch (Exception paramWebView) {
          a.e(paramWebView);
        } 
      } else {
        this.dEm.pf(paramString);
      } 
    } 
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\webview\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */