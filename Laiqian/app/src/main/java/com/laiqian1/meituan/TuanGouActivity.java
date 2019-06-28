package com.laiqian.meituan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.laiqian.meituan.b.b;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.w;
import com.laiqian.ui.s;
import com.laiqian.ui.webview.PosWebViewLinearLayout;
import java.util.ArrayList;

@SuppressLint({"SetJavaScriptEnabled"})
public class TuanGouActivity extends ActivityRoot implements b {
  ah bpX;
  
  private BroadcastReceiver bpZ = new am(this);
  
  a brm;
  
  aa titleBar;
  
  private void Ek() {
    int i = Build.VERSION.SDK_INT;
    this.brm.aQH.setWebViewClient(new ak(this));
    this.brm.aQH.addJavascriptInterface(new ap(this), "Android");
    this.brm.aQR.setOnClickListener(new al(this));
  }
  
  private void setupViews() {
    ((ViewGroup)this.brm.brq.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((ViewGroup)this.brm.brr.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    ((TextView)this.brm.brq.cAO.getView()).setText(getString(R.string.tuangou_name));
    ((TextView)this.brm.brr.cAO.getView()).setText(getString(R.string.tuangou_state));
  }
  
  public void B(ArrayList<ai> paramArrayList) {
    Eo();
    ((TextView)this.brm.brq.cAP.getView()).setText(((ai)paramArrayList.get(0)).name);
    ((TextView)this.brm.brr.cAP.getView()).setText(getString(R.string.tuangou_binded));
  }
  
  public void El() {}
  
  public void Em() {}
  
  public void En() {
    this.brm.aQH.setVisibility(0);
    this.brm.brp.setVisibility(8);
    this.brm.aQH.pf(b.ff(1));
  }
  
  public void Eo() {
    this.brm.aQH.setVisibility(8);
    this.titleBar.brj.setVisibility(8);
    this.brm.brp.setVisibility(0);
  }
  
  public void KU() {}
  
  public void Pq() { En(); }
  
  public void Pr() {}
  
  public void Ps() {}
  
  public void Pt() {}
  
  public void Pw() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("msg-token");
    registerReceiver(this.bpZ, intentFilter);
  }
  
  public void dE(boolean paramBoolean) {}
  
  public void hideProgress() {}
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.brm = a.m(this);
    this.titleBar = aa.M(this);
    this.titleBar.tvTitle.setText(getString(R.string.meituan_tuangou));
    this.titleBar.brj.setVisibility(8);
    setupViews();
    Ek();
    Pw();
    this.bpX = new ah(this, this, true);
    this.bpX.init();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    this.brm.aQH.onDestroy();
    unregisterReceiver(this.bpZ);
  }
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.activity_tuangou;
    
    public PosWebViewLinearLayout aQH;
    
    public Button aQR;
    
    public View brp;
    
    public w brq = new w(R.id.shop_name);
    
    public w brr = new w(R.id.shop_state);
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.aQR = (Button)s.z(param1View, R.id.btn_bind);
      this.brp = s.z(param1View, R.id.ll_bind_info);
      this.aQH = (PosWebViewLinearLayout)s.z(param1View, R.id.show_webview);
    }
    
    public static a m(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\TuanGouActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */