package com.laiqian.ui.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.util.bb;
import com.laiqian.util.bd;

public class SimplePosWebViewLinearLayout extends LinearLayout {
  private Context context;
  
  protected WebView dEc;
  
  LinearLayout dEd;
  
  private WebViewClient dEe;
  
  private TextView dEg;
  
  private a dEk;
  
  private View dEl;
  
  private boolean isShow = true;
  
  public SimplePosWebViewLinearLayout(Context paramContext) {
    super(paramContext);
    this.context = paramContext;
    initData();
  }
  
  public SimplePosWebViewLinearLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    initData();
  }
  
  private boolean apQ() {
    boolean bool = bd.bH(this.context);
    if (!bool) {
      if (this.dEd.getVisibility() == 8)
        showError(this.context.getResources().getString(R.string.sync_network_error)); 
      WifiManager wifiManager = (WifiManager)this.context.getSystemService("wifi");
      if (!wifiManager.isWifiEnabled()) {
        wifiManager.setWifiEnabled(true);
        return bool;
      } 
    } else if (this.dEd.getVisibility() == 0) {
      this.dEd.setVisibility(8);
    } 
    return bool;
  }
  
  private boolean asr() {
    try {
      boolean bool = ((Activity)this.context).isFinishing();
      return bool ^ true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  @SuppressLint({"JavascriptInterface", "NewApi"})
  private void ass() {
    this.dEc.getSettings().setBuiltInZoomControls(true);
    this.dEc.getSettings().setUseWideViewPort(false);
    this.dEc.getSettings().setLoadWithOverviewMode(true);
    this.dEc.getSettings().setAllowFileAccess(true);
    this.dEc.getSettings().setAppCacheEnabled(true);
    this.dEc.getSettings().setDomStorageEnabled(true);
    this.dEc.getSettings().setDatabaseEnabled(true);
    if (Build.VERSION.SDK_INT >= 17)
      this.dEc.getSettings().setAllowUniversalAccessFromFileURLs(true); 
    this.dEc.setOnLongClickListener(new e(this));
    this.dEc.getSettings().setBuiltInZoomControls(false);
    f f = new f(this);
    this.dEc.setWebChromeClient(f);
    int i = Build.VERSION.SDK_INT;
    this.dEc.setWebViewClient(new g(this));
    this.dEc.getSettings().setJavaScriptEnabled(true);
  }
  
  private void initData() {
    if (this.dEk == null) {
      IntentFilter intentFilter = new IntentFilter();
      this.dEk = new a(this, null);
      intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.context.registerReceiver(this.dEk, intentFilter);
    } 
    initView();
  }
  
  private void initView() {
    View view = LayoutInflater.from(this.context).inflate(R.layout.webview_simple, null);
    this.dEd = (LinearLayout)view.findViewById(R.id.show_network);
    this.dEc = (WebView)view.findViewById(R.id.wv);
    this.dEg = (TextView)view.findViewById(R.id.syncError);
    this.dEl = view.findViewById(R.id.rlProgress);
    ass();
    addView(view);
  }
  
  private void showError(String paramString) {
    this.dEg.setText(paramString);
    this.dEc.setVisibility(0);
    this.dEd.setVisibility(0);
  }
  
  public void asq() { this.dEl.setVisibility(8); }
  
  public void onDestroy() {
    if (this.dEk != null)
      this.context.unregisterReceiver(this.dEk); 
    asq();
  }
  
  public void pf(String paramString) {
    this.dEd.setVisibility(8);
    this.dEc.setVisibility(0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("跳转");
    stringBuilder.append(paramString);
    bb.e("webview", stringBuilder.toString());
    bb.e("webview", Boolean.valueOf(this.isShow));
    if (this.isShow)
      showDialog(); 
    this.dEc.loadUrl(paramString);
  }
  
  public void showDialog() { this.dEl.setVisibility(0); }
  
  private class a extends BroadcastReceiver {
    private a(SimplePosWebViewLinearLayout this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) { SimplePosWebViewLinearLayout.e(this.dEm); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\webview\SimplePosWebViewLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */