package com.laiqian.print.type.net;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.keybord.a;
import com.laiqian.util.bd;
import com.laiqian.util.l;
import java.util.ArrayList;

public class ChangeNetPrinterIpActivity extends ActivityRoot implements v {
  a cKR;
  
  o cKS;
  
  a cKT;
  
  boolean cKU = false;
  
  boolean cKV = false;
  
  aa titleBar;
  
  private void ahB() {
    if (this.cKU && this.cKV) {
      this.cKR.cLk.setEnabled(true);
      return;
    } 
    this.cKR.cLk.setEnabled(false);
  }
  
  private void lH(String paramString) {
    this.cKU = bd.rU(paramString);
    ahB();
  }
  
  private void lI(String paramString) {
    this.cKV = bd.rU(paramString);
    ahB();
  }
  
  private void setListeners() {
    ArrayList arrayList = new ArrayList();
    for (byte b = 0; b < this.cKS.ahS().size(); b++)
      arrayList.add(this.cKS.a((x)this.cKS.ahS().get(b))); 
    this.cKR.cLb.setOnClickListener(new a(this, arrayList));
    this.cKR.cLk.setOnClickListener(new d(this));
    this.cKR.cLe.setVisibility(8);
    this.cKR.cLe.setOnClickListener(new e(this));
    this.cKR.cLj.setVisibility(8);
    this.cKR.cLj.setOnClickListener(new f(this));
    this.cKR.cLd.addTextChangedListener(new g(this));
    this.cKR.cLg.addTextChangedListener(new h(this));
    this.cKR.cLh.setOnClickListener(new i(this));
  }
  
  private void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131624759));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setVisibility(8);
    l.a(getWindow(), this.cKR.cLd);
    l.a(getWindow(), this.cKR.cLg);
    this.cKT = a.r(getWindow());
    this.cKR.cLa.setText(2131628710);
    this.cKR.cLc.setText(getString(2131624756));
    this.cKR.cLf.setText(getString(2131624754));
    this.cKR.cLk.setText(getString(2131624750));
    this.cKR.cLe.setText(getString(2131624746));
    this.cKR.cLj.setText(getString(2131624744));
    this.cKR.cLn.setText(getString(2131624757));
    this.cKR.cLg.setHint(getString(2131624753));
    this.cKR.cLh.setText(getString(2131624753));
    this.cKR.cLd.setSelection(this.cKR.cLd.getText().length());
    this.cKR.cLi.setVisibility(8);
    this.cKR.cLl.setVisibility(8);
  }
  
  public void ahC() {
    ahF();
    lJ(getString(2131624751));
  }
  
  public void ahD() {
    ahF();
    lJ(getString(2131624752));
  }
  
  public void ahE() {
    this.cKR.cLl.setVisibility(0);
    this.cKR.cLk.setText(" ");
  }
  
  public void ahF() {
    this.cKR.cLl.setVisibility(8);
    this.cKR.cLk.setText(getString(2131624750));
  }
  
  public void ahG() {
    this.cKR.cLi.setVisibility(0);
    this.cKR.cLh.setText(" ");
    this.cKR.cLh.setClickable(false);
  }
  
  public void ahH() { runOnUiThread(new k(this)); }
  
  public void ahI() { startActivity(new Intent("android.settings.WIFI_SETTINGS")); }
  
  public void lJ(String paramString) { runOnUiThread(new j(this, paramString)); }
  
  public void lK(String paramString) { this.cKR.cLd.setText(paramString); }
  
  public void lL(String paramString) { runOnUiThread(new c(this, paramString)); }
  
  public void lM(String paramString) { this.cKR.cLb.setText(paramString); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cKR = a.j(getWindow());
    this.titleBar = aa.M(this);
    this.cKS = new o(this, this);
    this.cKS.init();
    setupViews();
    setListeners();
    lH(this.cKR.cLd.getText().toString());
    ahB();
  }
  
  private static final class a {
    RelativeLayout aQo;
    
    TextView cLa;
    
    TextView cLb;
    
    TextView cLc;
    
    EditText cLd;
    
    Button cLe;
    
    TextView cLf;
    
    EditText cLg;
    
    Button cLh;
    
    ProgressBarCircularIndeterminate cLi;
    
    Button cLj;
    
    Button cLk;
    
    ProgressBarCircularIndeterminate cLl;
    
    TextView cLm;
    
    TextView cLn;
    
    View cLo;
    
    a(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.cLa = (TextView)param1View.findViewById(2131299492);
      this.cLb = (TextView)param1View.findViewById(2131299491);
      this.cLc = (TextView)param1View.findViewById(2131299618);
      this.cLd = (EditText)param1View.findViewById(2131297003);
      this.cLe = (Button)param1View.findViewById(2131296621);
      this.cLf = (TextView)param1View.findViewById(2131299608);
      this.cLg = (EditText)param1View.findViewById(2131297002);
      this.cLh = (Button)param1View.findViewById(2131296638);
      this.cLi = (ProgressBarCircularIndeterminate)param1View.findViewById(2131298382);
      this.cLj = (Button)param1View.findViewById(2131296625);
      this.cLk = (Button)param1View.findViewById(2131296637);
      this.cLl = (ProgressBarCircularIndeterminate)param1View.findViewById(2131298381);
      this.cLm = (TextView)param1View.findViewById(2131299535);
      this.cLn = (TextView)param1View.findViewById(2131299556);
      this.cLo = param1View.findViewById(2131297579);
    }
    
    static a j(Window param1Window) {
      a a1 = r(LayoutInflater.from(param1Window.getContext()));
      param1Window.setContentView(a1.aQo);
      return a1;
    }
    
    static a r(LayoutInflater param1LayoutInflater) { return new a(param1LayoutInflater.inflate(2131427367, null)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\ChangeNetPrinterIpActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */