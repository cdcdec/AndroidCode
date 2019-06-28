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
import com.laiqian.ui.a.bb;
import com.laiqian.util.bb;
import com.laiqian.util.bd;

public class PosWebViewLinearLayout extends LinearLayout {
  private Context context;
  
  protected WebView dEc;
  
  LinearLayout dEd;
  
  private WebViewClient dEe;
  
  private a dEf;
  
  private TextView dEg;
  
  private boolean isShow = true;
  
  private bb mWaitingDialog = null;
  
  public PosWebViewLinearLayout(Context paramContext) {
    super(paramContext);
    this.context = paramContext;
    initData();
  }
  
  public PosWebViewLinearLayout(Context paramContext, AttributeSet paramAttributeSet) {
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
    this.dEc.getSettings().setJavaScriptEnabled(true);
    this.dEc.getSettings().setBuiltInZoomControls(true);
    this.dEc.getSettings().setUseWideViewPort(false);
    this.dEc.getSettings().setLoadWithOverviewMode(true);
    this.dEc.getSettings().setAllowFileAccess(true);
    this.dEc.getSettings().setAppCacheEnabled(true);
    this.dEc.getSettings().setDomStorageEnabled(true);
    this.dEc.getSettings().setDatabaseEnabled(true);
    if (Build.VERSION.SDK_INT >= 17)
      this.dEc.getSettings().setAllowUniversalAccessFromFileURLs(true); 
    this.dEc.setOnLongClickListener(new a(this));
    b b = new b(this);
    this.dEc.setWebChromeClient(b);
    this.dEc.setWebViewClient(new c(this));
    this.dEc.setDownloadListener(new d(this));
  }
  
  private void initData() {
    if (this.dEf == null) {
      IntentFilter intentFilter = new IntentFilter();
      this.dEf = new a(this, null);
      intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.context.registerReceiver(this.dEf, intentFilter);
    } 
    initView();
  }
  
  private void initView() {
    View view = LayoutInflater.from(this.context).inflate(R.layout.webview_10800, null);
    this.dEd = (LinearLayout)view.findViewById(R.id.show_network);
    this.dEc = (WebView)view.findViewById(R.id.wv);
    this.dEg = (TextView)view.findViewById(R.id.syncError);
    ass();
    addView(view);
  }
  
  private void showError(String paramString) {
    this.dEg.setText(paramString);
    this.dEc.setVisibility(0);
    this.dEd.setVisibility(0);
  }
  
  private bb xS() {
    if (this.mWaitingDialog == null) {
      Context context1 = this.context;
      this.mWaitingDialog = new bb(this.context);
      this.mWaitingDialog.setCancelable(true);
    } 
    return this.mWaitingDialog;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString) { this.dEc.addJavascriptInterface(paramObject, paramString); }
  
  public void asq() {
    if (this.mWaitingDialog != null && asr() && this.mWaitingDialog.isShowing())
      this.mWaitingDialog.dismiss(); 
  }
  
  public boolean canGoBack() { return this.dEc.canGoBack(); }
  
  public void goBack() { this.dEc.goBack(); }
  
  public void onDestroy() {
    if (this.dEf != null)
      this.context.unregisterReceiver(this.dEf); 
    asq();
  }
  
  public void pf(String paramString) {
    this.dEd.setVisibility(8);
    this.dEc.setVisibility(0);
    stringBuilder = new StringBuilder();
    stringBuilder.append("跳转");
    stringBuilder.append(paramString);
    bb.e("webview", stringBuilder.toString());
    bb.e("webview", Boolean.valueOf(this.isShow));
    if (this.isShow)
      try {
        xS().show();
      } catch (Exception stringBuilder) {} 
    this.dEc.loadUrl(paramString);
  }
  
  public void reload() {
    if (this.dEc != null) {
      this.dEc.reload();
      showDialog();
    } 
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient) { this.dEe = paramWebViewClient; }
  
  public void showDialog() {
    if (this.mWaitingDialog != null && this.mWaitingDialog.isShowing())
      return; 
    if (asr())
      xS().show(); 
  }
  
  private class a extends BroadcastReceiver {
    private a(PosWebViewLinearLayout this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) { PosWebViewLinearLayout.f(this.dEh); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\webview\PosWebViewLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */