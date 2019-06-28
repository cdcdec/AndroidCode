package com.laiqian.pos.industry.weiorder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.webview.PosWebViewLinearLayout;
import com.laiqian.util.av;

public class WeshopBindingActivity extends ActivityRoot {
  View.OnClickListener aDd = new dj(this);
  
  private PosWebViewLinearLayout aQH;
  
  View.OnClickListener azO = new di(this);
  
  private Button cvt;
  
  Button cvu;
  
  private View cvv;
  
  private String cvw = null;
  
  private TextView tvTitle;
  
  private void initData() { this.aQH.pf(this.cvw); }
  
  private void yP() {
    this.cvv.setOnClickListener(this.azO);
    this.cvt.setOnClickListener(this.aDd);
    this.cvu.setOnClickListener(new dk(this));
  }
  
  private void yR() {
    this.tvTitle = (TextView)findViewById(2131299265);
    this.cvv = findViewById(2131299247);
    this.cvt = (Button)findViewById(2131299253);
    this.aQH = (PosWebViewLinearLayout)findViewById(2131298991);
    this.cvu = (Button)findViewById(2131299254);
    this.tvTitle.setText(getString(2131630528));
    this.cvu.setText(getString(2131630527));
    this.cvt.setText(getString(2131630649));
  }
  
  public void finish() {
    super.finish();
    overridePendingTransition(2130772021, 2130771981);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428194);
    getWindow().setFeatureInt(7, 2131428209);
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
    av av = new av(this);
    String str = av.Tx();
    av.close();
    this.cvw = WeiOrderSettingFragment.jO(str);
    initData();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeshopBindingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */