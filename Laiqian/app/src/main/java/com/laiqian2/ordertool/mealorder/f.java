package com.laiqian.ordertool.mealorder;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class f extends WebViewClient {
  f(MealOrderIntroFragment paramMealOrderIntroFragment) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\mealorder\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */