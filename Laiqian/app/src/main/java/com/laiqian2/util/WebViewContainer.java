package com.laiqian.util;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.webview.PosWebViewLinearLayout;

public class WebViewContainer extends ActivityRoot {
  View.OnClickListener aDd = new cp(this);
  
  private Button aGS;
  
  private PosWebViewLinearLayout aQH;
  
  private View azH;
  
  View.OnClickListener azO = new co(this);
  
  private TextView bLV;
  
  private String cvw = null;
  
  private String dGS = "店铺后台";
  
  private int dGT = -1;
  
  private void initData() { this.aQH.pf(this.cvw); }
  
  private void yP() {
    this.azH.setOnClickListener(this.azO);
    this.aGS.setOnClickListener(this.aDd);
  }
  
  private void yR() {
    this.bLV = (TextView)findViewById(R.id.ui_titlebar_txt);
    this.azH = findViewById(R.id.ui_titlebar_back_btn);
    this.aGS = (Button)findViewById(R.id.ui_titlebar_help_btn);
    this.aQH = (PosWebViewLinearLayout)findViewById(R.id.show_webview);
    this.aGS.setText(getString(R.string.wifi_refresh));
  }
  
  public void finish() {
    super.finish();
    overridePendingTransition(R.anim.pos_nomove, R.anim.activity_out_top);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.webview_container);
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    yR();
    yP();
  }
  
  public void onDestroy() {
    super.onDestroy();
    if (this.aQH != null)
      this.aQH.onDestroy(); 
  }
  
  public void onResume() {
    super.onResume();
    try {
      Intent intent = getIntent();
      this.cvw = intent.getStringExtra("sWebUrlKey");
      this.dGS = intent.getStringExtra("sWebTitleKey");
      this.dGT = intent.getIntExtra("sWebWidth", -1);
      if (this.dGT > 0) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.aQH.getLayoutParams();
        layoutParams.width = this.dGT;
        this.aQH.setLayoutParams(layoutParams);
      } 
      this.bLV.setText(this.dGS);
    } catch (Exception exception) {}
    if (this.cvw != null) {
      initData();
      return;
    } 
    finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\WebViewContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */