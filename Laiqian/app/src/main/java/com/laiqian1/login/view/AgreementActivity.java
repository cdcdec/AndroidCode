package com.laiqian.login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.login.a.a;
import com.laiqian.models.at;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.aa;

public class AgreementActivity extends ActivityRoot {
  private EditText aYT;
  
  private LinearLayout aYU;
  
  private ImageView aYV;
  
  private Button aYW;
  
  private aa titleBar;
  
  private void JZ() {
    this.aYU.setOnClickListener(new a(this));
    this.titleBar.bri.setOnClickListener(new b(this));
    this.aYW.setOnClickListener(new a(this, this));
  }
  
  private void initView() {
    this.titleBar = aa.M(this);
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setVisibility(8);
    this.titleBar.tvTitle.setVisibility(8);
    ((TextView)findViewById(2131299812)).setText(2131630352);
    this.aYT = (EditText)findViewById(2131297740);
    this.aYU = (LinearLayout)findViewById(2131298093);
    this.aYW = (Button)findViewById(2131296510);
    this.aYV = (ImageView)findViewById(2131297364);
    String str = getResources().getString(2131629360);
    this.aYT.setText(Html.fromHtml(str));
  }
  
  public void onBackPressed() { super.onBackPressed(); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427359);
    initView();
    JZ();
  }
  
  class a extends a.a {
    private boolean aYY;
    
    private Activity azD;
    
    public a(AgreementActivity this$0, Activity param1Activity) {
      super(param1Activity);
      this.azD = param1Activity;
    }
    
    protected boolean h(Intent param1Intent) {
      this.aYY = AgreementActivity.b(this.aYX).isSelected();
      return this.aYY;
    }
    
    protected void i(Intent param1Intent) {
      super.i(param1Intent);
      (new at(this.mActivity)).Ws();
      this.aYX.finish();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\AgreementActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */