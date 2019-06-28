package com.laiqian.pos.industry.weiorder.auth;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import com.laiqian.pos.industry.b;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import java.util.HashMap;

public class WechatAutoActivity extends ActivityRoot implements c {
  View.OnClickListener aDd = new e(this);
  
  View.OnClickListener azO = new d(this);
  
  private Button cvt;
  
  Button cvu;
  
  private View cvv;
  
  private WebView cyb;
  
  b cyc;
  
  Handler mHandler = new h(this);
  
  private TextView tvTitle;
  
  private void yP() {
    this.cvv.setOnClickListener(this.azO);
    this.cvt.setOnClickListener(this.aDd);
    this.cvu.setOnClickListener(new f(this));
    int i = Build.VERSION.SDK_INT;
    this.cyb.setWebViewClient(new g(this));
    WebSettings webSettings = this.cyb.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setAllowFileAccess(true);
    webSettings.setBuiltInZoomControls(false);
    this.cyb.addJavascriptInterface(this, "ViewObject");
  }
  
  private void yR() {
    this.tvTitle = (TextView)findViewById(2131299265);
    this.cvv = findViewById(2131299247);
    this.cvt = (Button)findViewById(2131299253);
    this.cyb = (WebView)findViewById(2131298991);
    this.cvu = (Button)findViewById(2131299254);
    this.tvTitle.setText(getString(2131630528));
    this.cvu.setText(getString(2131630527));
    this.cvt.setText(getString(2131630649));
  }
  
  @JavascriptInterface
  public void close(String paramString) { this.mHandler.sendEmptyMessage(Integer.valueOf(paramString).intValue()); }
  
  public void finish() {
    super.finish();
    overridePendingTransition(2130772021, 2130771981);
  }
  
  public void ki(String paramString) { this.cyb.loadUrl(paramString); }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428196);
    getWindow().setFeatureInt(7, 2131428209);
    this.cyc = new b(this, this);
    yR();
    yP();
  }
  
  public void onDestroy() { super.onDestroy(); }
  
  public void onResume() {
    super.onResume();
    av av = new av(this);
    String str = av.Tx();
    av.close();
    HashMap hashMap = new HashMap();
    hashMap.put("shopid", str);
    str = bh.aa(hashMap);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b.crL);
    stringBuilder.append("?");
    stringBuilder.append(str);
    ki(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\auth\WechatAutoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */