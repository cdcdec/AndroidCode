package com.laiqian.product;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.laiqian.infrastructure.R;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.n;

public class Mall extends ActivityRoot {
  private View aJa;
  
  private String aPj;
  
  private WebView cOE;
  
  private View cOF;
  
  private View cOG;
  
  private boolean cOH;
  
  private boolean cgE;
  
  private void gk(boolean paramBoolean) {
    if (paramBoolean) {
      this.cOE.loadUrl(this.aPj);
    } else {
      this.cOE.reload();
    } 
    this.cOF.setVisibility(8);
  }
  
  public void finish() {
    if (this.cOE.canGoBack()) {
      this.cOE.goBack();
      return;
    } 
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.pos_mall);
    setTitleTextViewHideRightView(R.string.pos_mall);
    this.aPj = getIntent().getStringExtra("url");
    if (this.aPj == null) {
      this.aPj = RootUrlParameter.clu;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.aPj);
      stringBuilder.append("?language=");
      stringBuilder.append(n.bM(this));
      this.aPj = stringBuilder.toString();
    } 
    this.aJa = findViewById(R.id.loading);
    this.cOF = findViewById(R.id.reload_l);
    this.cOG = this.cOF.findViewById(R.id.reload);
    this.cOG.setOnClickListener(new a(this));
    this.cOH = true;
    this.cgE = true;
    this.cOE = (WebView)findViewById(R.id.webview);
    int i = Build.VERSION.SDK_INT;
    this.cOE.setWebViewClient(new b(this));
    this.cOE.setWebChromeClient(new c(this));
    this.cOE.getSettings().setCacheMode(-1);
    this.cOE.getSettings().setJavaScriptEnabled(true);
    gk(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\Mall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */