package com.laiqian.eleme;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.l;
import com.laiqian.ui.s;
import com.laiqian.ui.webview.PosWebViewLinearLayout;
import com.laiqian.util.n;
import java.util.ArrayList;

@SuppressLint({"SetJavaScriptEnabled"})
public class ElemeActivity extends ActivityRoot implements k {
  i aQA;
  
  m aQB;
  
  ArrayList<j> aQC;
  
  ArrayList<j> aQD;
  
  String aQE;
  
  a aQz;
  
  Handler mHandler = new a(this);
  
  aa titleBar;
  
  private void Ek() {
    this.aQz.aQI.setOnClickListener(new b(this));
    int j = Build.VERSION.SDK_INT;
    this.aQz.aQH.setWebViewClient(new c(this));
    this.aQz.aQH.addJavascriptInterface(this, "ViewObject");
    this.titleBar.brj.setOnClickListener(new d(this));
    ((CheckBox)this.aQz.aQS.dwV.getView()).setOnCheckedChangeListener(new e(this));
    this.aQz.aQR.setOnClickListener(new f(this));
  }
  
  public void El() {
    this.aQz.aQH.setVisibility(8);
    this.titleBar.brj.setVisibility(0);
    this.aQz.aQJ.setVisibility(8);
    this.aQz.aQL.setVisibility(0);
  }
  
  public void Em() { this.aQz.aNv.setVisibility(0); }
  
  public void En() {
    if (this.aQE == null)
      return; 
    this.aQz.aQH.setVisibility(0);
    this.aQz.aQJ.setVisibility(8);
    this.aQz.aQL.setVisibility(8);
    this.aQz.aNv.setVisibility(8);
    this.aQz.aQM.setVisibility(8);
    this.aQz.aQP.setVisibility(8);
    this.aQz.aQH.pf(this.aQE);
  }
  
  public void Eo() {
    this.aQz.aNv.setVisibility(8);
    this.aQz.aQH.setVisibility(8);
    this.aQz.aQL.setVisibility(8);
    this.titleBar.brj.setVisibility(0);
    this.aQz.aQJ.setVisibility(0);
  }
  
  public void a(ArrayList<j> paramArrayList, String[] paramArrayOfString) {
    b(paramArrayList, paramArrayOfString);
    ((ViewGroup)this.aQz.aQS.getView()).setVisibility(0);
    this.aQz.aQP.setVisibility(8);
    this.aQz.aQM.setBackgroundColor(getResources().getColor(R.color.backgroup_green));
    this.aQz.aQO.setImageResource(R.drawable.icon_takeaway_bind);
    this.aQz.aQN.setText(R.string.takeaway_binded);
    this.aQz.aQM.setVisibility(0);
    this.aQz.aQJ.setVisibility(0);
  }
  
  public void b(ArrayList<j> paramArrayList, String[] paramArrayOfString) {
    Eo();
    this.aQC = l.c(paramArrayList, paramArrayOfString);
    if (this.aQC == null)
      return; 
    if (this.aQB == null) {
      this.aQB = new m(this.aQC, this, new g(this));
    } else {
      this.aQB.g(paramArrayList);
    } 
    this.aQz.aQK.setAdapter(this.aQB);
    n.c(this.aQz.aQK);
  }
  
  public void b(String[] paramArrayOfString, boolean paramBoolean) {
    if (paramBoolean) {
      for (byte b = 0; b < this.aQC.size(); b++) {
        byte b1;
        for (b1 = 0; b1 < paramArrayOfString.length; b1++) {
          if (paramArrayOfString[b1].equals(String.valueOf(((j)this.aQC.get(b)).id)))
            ((j)this.aQC.get(b)).aRa = true; 
        } 
      } 
      this.aQB.notifyDataSetChanged();
    } 
  }
  
  public void cJ(String paramString) {
    this.aQE = paramString;
    this.titleBar.brj.setVisibility(0);
    ((ViewGroup)this.aQz.aQS.getView()).setVisibility(8);
    this.aQz.aQP.setVisibility(0);
    this.aQz.aQJ.setVisibility(8);
    this.aQz.aQQ.setText(String.format(getString(R.string.takeaway_bind_note), new Object[] { getString(R.string.eleme_title) }));
    this.aQz.aQM.setBackgroundColor(getResources().getColor(R.color.setting_text_color2));
    this.aQz.aQO.setImageResource(R.drawable.icon_takeaway_unbind);
    this.aQz.aQN.setText(R.string.takeaway_unbind);
    this.aQz.aQM.setVisibility(0);
  }
  
  public void cK(String paramString) {
    this.aQE = paramString;
    En();
  }
  
  @JavascriptInterface
  public void close() { this.mHandler.sendEmptyMessage(0); }
  
  public void hideProgress() { this.aQz.aNv.setVisibility(8); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.aQz = a.h(this);
    this.titleBar = aa.M(this);
    this.titleBar.tvTitle.setText(getString(R.string.eleme));
    this.titleBar.brj.setVisibility(0);
    this.titleBar.brj.setText(R.string.eleme_auth_admin);
    ((TextView)this.aQz.aQS.cAO.getView()).setText(getString(R.string.auto_confirm));
    ((CheckBox)this.aQz.aQS.dwV.getView()).setChecked(a.AZ().Cg());
    ((ViewGroup)this.aQz.aQS.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    this.aQA = new i(this, this);
    Ek();
    this.aQA.init();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    this.aQz.aQH.onDestroy();
  }
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.activity_eleme_setting;
    
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
      this.aQL = (ViewGroup)s.z(param1View, R.id.ll_refresh);
      this.aQI = (Button)s.z(param1View, R.id.btn_refresh);
      this.aQJ = (ViewGroup)s.z(param1View, R.id.ll_setting);
      this.aQK = (ListView)s.z(param1View, R.id.lv_setting);
      this.aQM = (ViewGroup)s.z(param1View, R.id.ll_bind_status);
      this.aQN = (TextView)s.z(param1View, R.id.tv_bind_status);
      this.aQO = (ImageView)s.z(param1View, R.id.iv_bind_status);
      this.aQP = (ViewGroup)s.z(param1View, R.id.ll_unbind);
      this.aQQ = (TextView)s.z(param1View, R.id.tv_bind_note);
      this.aQR = (Button)s.z(param1View, R.id.btn_bind);
      this.aNv = (ProgressBarCircularIndeterminate)s.z(param1View, R.id.ivProgress);
    }
    
    public static a h(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\eleme\ElemeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */