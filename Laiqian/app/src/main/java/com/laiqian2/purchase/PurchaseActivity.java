package com.laiqian.purchase;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.models.v;
import com.laiqian.pos.industry.b;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.n;

public class PurchaseActivity extends ActivityRoot {
  private TextView cXO;
  
  private View cXP;
  
  private String clr;
  
  private WebView cyb;
  
  private void Ek() {
    int i = Build.VERSION.SDK_INT;
    this.cyb.setWebViewClient(new b(this));
    WebSettings webSettings = this.cyb.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setAllowFileAccess(true);
    webSettings.setBuiltInZoomControls(true);
    webSettings.setCacheMode(-1);
    this.cyb.addJavascriptInterface(this, "RawModel");
  }
  
  public boolean beforeCloseActivity() {
    String str = this.cyb.getUrl();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("地址：");
    stringBuilder.append(str);
    n.println(stringBuilder.toString());
    if (str != null && str.startsWith(b.crx))
      return false; 
    if (this.cyb.canGoBack()) {
      this.cyb.goBack();
      return true;
    } 
    return false;
  }
  
  @JavascriptInterface
  public void changeTitle(String paramString) {
    n.g("网页端返回的标题", paramString);
    runOnUiThread(new c(this, paramString));
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427409);
    String str = CrashApplication.getLaiqianPreferenceManager().Tx();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(b.crM);
    stringBuilder1.append("?shopid=");
    stringBuilder1.append(str);
    stringBuilder1.append("#/mine");
    this.clr = stringBuilder1.toString();
    this.cXO = setTitleTextView(2131627723);
    this.cXP = setTitleTextViewRight(2131629083, new a(this));
    this.cyb = (WebView)findViewById(2131298991);
    Ek();
    WebView webView = this.cyb;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(b.crx);
    stringBuilder2.append("?shopid=");
    stringBuilder2.append(str);
    webView.loadUrl(stringBuilder2.toString());
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.cyb.getParent() != null)
      ((ViewGroup)this.cyb.getParent()).removeView(this.cyb); 
    this.cyb.destroy();
  }
  
  @JavascriptInterface
  public String rawStorage(long[] paramArrayOfLong, double[] paramArrayOfDouble) {
    v v = new v(this);
    String str = v.rawStorage(paramArrayOfLong, paramArrayOfDouble);
    v.close();
    return str;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\purchase\PurchaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */