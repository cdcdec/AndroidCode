package com.laiqian.meituan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.meituan.a.a;
import com.laiqian.meituan.b.b;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.l;
import com.laiqian.ui.s;
import com.laiqian.ui.webview.PosWebViewLinearLayout;
import com.laiqian.util.n;
import java.util.ArrayList;

@SuppressLint({"SetJavaScriptEnabled"})
public class MeituanActivity extends ActivityRoot implements b {
  private t baI;
  
  aj bpV;
  
  a bpW;
  
  ah bpX;
  
  a bpY;
  
  private BroadcastReceiver bpZ = new q(this);
  
  bb mWaitingDialog = null;
  
  private void Ek() {
    this.bpW.aQR.setOnClickListener(new j(this));
    this.bpV.brk.setOnClickListener(new k(this));
    this.bpV.brl.setOnClickListener(new l(this));
    int i = Build.VERSION.SDK_INT;
    this.bpW.aQH.setWebViewClient(new m(this));
    this.bpW.aQH.addJavascriptInterface(new ap(this), "Android");
    this.bpV.brj.setOnClickListener(new n(this));
    ((CheckBox)this.bpW.aQS.dwV.getView()).setOnCheckedChangeListener(new o(this));
    this.bpW.aQI.setOnClickListener(new p(this));
  }
  
  public void B(ArrayList<ai> paramArrayList) {
    Eo();
    Pv();
    if (this.bpY == null) {
      this.bpY = new a(paramArrayList, this);
    } else {
      this.bpY.g(paramArrayList);
    } 
    this.bpW.aQK.setAdapter(this.bpY);
    n.c(this.bpW.aQK);
  }
  
  public void El() {
    this.bpW.aQH.setVisibility(8);
    this.bpV.brj.setVisibility(0);
    this.bpW.aQJ.setVisibility(8);
    this.bpW.aQL.setVisibility(0);
    this.bpW.aNv.setVisibility(8);
  }
  
  public void Em() {
    this.bpW.aNv.setVisibility(0);
    this.bpW.aQJ.setVisibility(8);
    this.bpW.aQM.setVisibility(8);
  }
  
  public void En() {
    this.bpW.aQH.setVisibility(0);
    this.bpW.aQJ.setVisibility(8);
    this.bpV.brj.setVisibility(0);
    this.bpW.aQH.pf(b.ff(2));
    this.bpW.aQL.setVisibility(8);
    this.bpW.aNv.setVisibility(8);
    this.bpW.aQM.setVisibility(8);
    this.bpW.aQP.setVisibility(8);
  }
  
  public void Eo() {
    this.bpW.aQH.setVisibility(8);
    this.bpV.brj.setVisibility(0);
    this.bpW.aQJ.setVisibility(0);
    this.bpW.aQL.setVisibility(8);
    this.bpW.aNv.setVisibility(8);
  }
  
  public void KU() {
    if (this.baI == null)
      this.baI = new t(this); 
    this.baI.show();
  }
  
  public void Pq() {
    this.bpV.brj.setVisibility(0);
    ((ViewGroup)this.bpW.aQS.getView()).setVisibility(8);
    this.bpW.aQP.setVisibility(0);
    this.bpW.aQJ.setVisibility(8);
    this.bpW.aQQ.setText(String.format(getString(R.string.takeaway_bind_note), new Object[] { getString(R.string.meituan) }));
    this.bpW.aQM.setBackgroundColor(getResources().getColor(R.color.setting_text_color2));
    this.bpW.aQO.setImageResource(R.drawable.icon_takeaway_unbind);
    this.bpW.aQN.setText(R.string.takeaway_unbind);
    this.bpW.aQM.setVisibility(0);
    this.bpW.aQH.setVisibility(8);
  }
  
  public void Pr() { this.bpV.brj.setVisibility(0); }
  
  public void Ps() {
    if (this.mWaitingDialog == null)
      this.mWaitingDialog = new bb(this); 
    this.mWaitingDialog.setCancelable(false);
    this.mWaitingDialog.show();
  }
  
  public void Pt() {
    if (this.mWaitingDialog != null) {
      this.mWaitingDialog.dismiss();
      this.mWaitingDialog = null;
    } 
  }
  
  public void Pv() {
    this.bpV.brj.setVisibility(0);
    ((ViewGroup)this.bpW.aQS.getView()).setVisibility(0);
    this.bpW.aQP.setVisibility(8);
    this.bpW.aQM.setBackgroundColor(getResources().getColor(R.color.backgroup_green));
    this.bpW.aQO.setImageResource(R.drawable.icon_takeaway_bind);
    this.bpW.aQN.setText(R.string.takeaway_binded);
    this.bpW.aQM.setVisibility(0);
    this.bpW.aQJ.setVisibility(0);
    this.bpW.aQH.setVisibility(8);
  }
  
  public void Pw() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("msg-token");
    registerReceiver(this.bpZ, intentFilter);
  }
  
  public void dE(boolean paramBoolean) { this.bpV.brj.setEnabled(paramBoolean); }
  
  public void hideProgress() { this.bpW.aNv.setVisibility(8); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.bpW = a.k(this);
    this.bpV = aj.l(this);
    this.bpV.tvTitle.setText(getString(R.string.meituan_title));
    this.bpV.brj.setVisibility(0);
    this.bpV.brj.setText(R.string.meituan_auth_admin);
    this.bpV.brk.setText(R.string.phone_number_error_doc);
    this.bpV.brl.setText(R.string.query_phone_number_error);
    ((TextView)this.bpW.aQS.cAO.getView()).setText(getString(R.string.auto_confirm));
    ((CheckBox)this.bpW.aQS.dwV.getView()).setChecked(a.AZ().Cf());
    ((ViewGroup)this.bpW.aQS.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    Pw();
    this.bpX = new ah(this, this, 2);
    Ek();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    this.bpW.aQH.onDestroy();
    unregisterReceiver(this.bpZ);
  }
  
  protected void onResume() {
    super.onResume();
    this.bpX.init();
  }
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.activity_meituan_setting;
    
    public ProgressBarCircularIndeterminate aNv;
    
    public View aQG;
    
    public PosWebViewLinearLayout aQH;
    
    public Button aQI;
    
    public ViewGroup aQJ;
    
    public ListView aQK;
    
    public ViewGroup aQL;
    
    public ViewGroup aQM;
    
    public TextView aQN;
    
    public ImageView aQO;
    
    public ViewGroup aQP;
    
    public TextView aQQ;
    
    public Button aQR;
    
    public l aQS = new l(R.id.auto_confirm_layout);
    
    private Context context;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.aQG = param1View;
      this.context = param1View.getContext();
      this.aQH = (PosWebViewLinearLayout)s.z(param1View, R.id.show_webview);
      this.aQJ = (ViewGroup)s.z(param1View, R.id.ll_setting);
      this.aQI = (Button)s.z(param1View, R.id.btn_refresh);
      this.aQL = (ViewGroup)s.z(param1View, R.id.ll_refresh);
      this.aQK = (ListView)s.z(param1View, R.id.lv_setting);
      this.aNv = (ProgressBarCircularIndeterminate)s.z(param1View, R.id.ivProgress);
      this.aQM = (ViewGroup)s.z(param1View, R.id.ll_bind_status);
      this.aQN = (TextView)s.z(param1View, R.id.tv_bind_status);
      this.aQO = (ImageView)s.z(param1View, R.id.iv_bind_status);
      this.aQP = (ViewGroup)s.z(param1View, R.id.ll_unbind);
      this.aQQ = (TextView)s.z(param1View, R.id.tv_bind_note);
      this.aQR = (Button)s.z(param1View, R.id.btn_bind);
    }
    
    public static a k(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\MeituanActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */