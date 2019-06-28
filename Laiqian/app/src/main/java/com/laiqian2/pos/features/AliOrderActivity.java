package com.laiqian.pos.features;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.pos.hardware.q;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;
import com.laiqian.ui.webview.SimplePosWebViewLinearLayout;

public class AliOrderActivity extends Activity {
  a cjo;
  
  private View currentView;
  
  aa titleBar;
  
  String url = q.clv;
  
  private void a(View paramView, String paramString) {
    if (this.currentView != null)
      this.currentView.setSelected(false); 
    this.currentView = paramView;
    this.currentView.setSelected(true);
    SimplePosWebViewLinearLayout simplePosWebViewLinearLayout = this.cjo.cjv;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.url);
    stringBuilder.append(paramString);
    simplePosWebViewLinearLayout.pf(stringBuilder.toString());
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cjo = a.t(this);
    this.titleBar = aa.M(this);
    setupViews();
    setListeners();
    a(this.cjo.cjt, "15");
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.cjo.cjv.onDestroy();
  }
  
  public void setListeners() {
    this.titleBar.bri.setOnClickListener(new a(this));
    this.cjo.cjq.setOnClickListener(new b(this));
    this.cjo.cjr.setOnClickListener(new c(this));
    this.cjo.cjt.setOnClickListener(new d(this));
    this.cjo.cjs.setOnClickListener(new e(this));
    this.cjo.cju.setOnClickListener(new f(this));
  }
  
  public void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131626406));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setVisibility(8);
  }
  
  public static class a {
    public View aQG;
    
    public ViewGroup cjq;
    
    public ViewGroup cjr;
    
    public ViewGroup cjs;
    
    public ViewGroup cjt;
    
    public ViewGroup cju;
    
    public SimplePosWebViewLinearLayout cjv;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cjq = (ViewGroup)s.z(param1View, 2131296338);
      this.cjr = (ViewGroup)s.z(param1View, 2131298291);
      this.cjs = (ViewGroup)s.z(param1View, 2131298307);
      this.cjt = (ViewGroup)s.z(param1View, 2131297137);
      this.cju = (ViewGroup)s.z(param1View, 2131296793);
      this.cjv = (SimplePosWebViewLinearLayout)s.z(param1View, 2131298991);
    }
    
    public static a t(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427360, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\AliOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */