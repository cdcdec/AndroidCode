package com.laiqian.product;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.laiqian.infrastructure.R;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.n;

class b extends WebViewClient {
  b(Mall paramMall) {}
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (paramString.startsWith(RootUrlParameter.clu)) {
      Mall.b(this.cOI, true);
      Mall.a(this.cOI, R.string.pos_mall);
      return;
    } 
    Mall.b(this.cOI, false);
    Mall.b(this.cOI, R.string.pos_mall_details);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是加载失败，代号：");
    stringBuilder.append(paramInt);
    stringBuilder.append(",description:");
    stringBuilder.append(paramString1);
    stringBuilder.append(",failingUrl:");
    stringBuilder.append(paramString2);
    n.println(stringBuilder.toString());
    Mall.a(this.cOI).setVisibility(0);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) { return false; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */