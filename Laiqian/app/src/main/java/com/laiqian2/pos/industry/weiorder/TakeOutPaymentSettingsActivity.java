package com.laiqian.pos.industry.weiorder;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.ab;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.l;

public class TakeOutPaymentSettingsActivity extends ActivityRoot implements bj {
  bh ctA;
  
  a ctz;
  
  aa titleBar;
  
  private void abi() {
    r r = new r(this, new au(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  private void setListeners() {
    this.titleBar.bri.setOnClickListener(new as(this));
    this.titleBar.brj.setOnClickListener(new az(this));
    ((CheckBox)this.ctz.ctC.dwV.getView()).setOnCheckedChangeListener(new ba(this));
    ((CheckBox)this.ctz.ctD.dwV.getView()).setOnCheckedChangeListener(new bb(this));
    ((CheckBox)this.ctz.ctE.dwV.getView()).setOnCheckedChangeListener(new bc(this));
    ((CheckBox)this.ctz.ctF.dwV.getView()).setOnCheckedChangeListener(new bd(this));
    ((ViewGroup)this.ctz.ctC.getView()).setOnClickListener(new be(this));
    ((ViewGroup)this.ctz.ctD.getView()).setOnClickListener(new bf(this));
    ((ViewGroup)this.ctz.ctE.getView()).setOnClickListener(new bg(this));
    ((ViewGroup)this.ctz.ctF.getView()).setOnClickListener(new at(this));
  }
  
  private void setupViews() {
    this.titleBar.brk.setVisibility(8);
    this.titleBar.brj.setText(getString(2131629495));
    this.titleBar.tvTitle.setText(getString(2131629993));
    ((TextView)this.ctz.ctl.getView()).setText(getString(2131629985));
    ((TextView)this.ctz.ctp.getView()).setText(getString(2131627171));
    ((TextView)this.ctz.ctC.cAO.getView()).setText(getString(2131630555));
    ((TextView)this.ctz.ctD.cAO.getView()).setText(getString(2131630549));
    ((TextView)this.ctz.ctE.cAO.getView()).setText(getString(2131626052));
    ((TextView)this.ctz.ctF.cAO.getView()).setText(getString(2131626056));
    ((ViewGroup)this.ctz.ctC.getView()).setBackground(getResources().getDrawable(2131230968));
    ((ViewGroup)this.ctz.ctD.getView()).setBackground(getResources().getDrawable(2131230968));
    ((ViewGroup)this.ctz.ctE.getView()).setBackground(getResources().getDrawable(2131230968));
    ((ViewGroup)this.ctz.ctF.getView()).setBackground(getResources().getDrawable(2131230968));
    ((TextView)this.ctz.ctr.getView()).setText(getString(2131629992));
    ((TextView)this.ctz.cts.getView()).setText(getString(2131629991));
  }
  
  public void Em() { ab.N(this); }
  
  public boolean Rq() { return true; }
  
  public void abj() {
    r r = new r(this, new av(this));
    r.setTitle("");
    r.t(getString(2131623944));
    r.oZ(getString(2131625961));
    r.s(getString(2131629994));
    r.show();
  }
  
  public void abk() {
    r r = new r(this, new aw(this));
    r.setTitle("");
    r.t(getString(2131623944));
    r.oZ(getString(2131625961));
    r.s(getString(2131629994));
    r.show();
  }
  
  public void abl() {
    r r = new r(this, new ax(this));
    r.setTitle("");
    r.t(getString(2131623944));
    r.oZ(getString(2131625961));
    r.s(getString(2131629989));
    r.show();
  }
  
  public void abm() {
    r r = new r(this, new ay(this));
    r.setTitle("");
    r.t(getString(2131623944));
    r.oZ(getString(2131625961));
    r.s(getString(2131629989));
    r.show();
  }
  
  public void fb(boolean paramBoolean) { ((CheckBox)this.ctz.ctC.dwV.getView()).setChecked(paramBoolean); }
  
  public void fc(boolean paramBoolean) { ((CheckBox)this.ctz.ctD.dwV.getView()).setChecked(paramBoolean); }
  
  public void fd(boolean paramBoolean) { ((CheckBox)this.ctz.ctE.dwV.getView()).setChecked(paramBoolean); }
  
  public void fe(boolean paramBoolean) { ((CheckBox)this.ctz.ctF.dwV.getView()).setChecked(paramBoolean); }
  
  public void ff(boolean paramBoolean) {
    if (paramBoolean) {
      ((ViewGroup)this.ctz.ctC.getView()).setVisibility(0);
      return;
    } 
    ((ViewGroup)this.ctz.ctC.getView()).setVisibility(8);
  }
  
  public void fg(boolean paramBoolean) {
    if (paramBoolean) {
      ((ViewGroup)this.ctz.ctE.getView()).setVisibility(0);
      return;
    } 
    ((ViewGroup)this.ctz.ctE.getView()).setVisibility(8);
  }
  
  public void hideProgress() { ab.P(this); }
  
  public void onBackPressed() {
    if (this.ctA.Az()) {
      abi();
      return;
    } 
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.ctz = a.x(this);
    this.titleBar = aa.M(this);
    this.ctA = new bh(this, this);
    this.ctA.init();
    setupViews();
    setListeners();
  }
  
  public void save() {
    if (Rq())
      this.ctA.save(); 
  }
  
  public void showError(String paramString) { Toast.makeText(this, paramString, 0).show(); }
  
  public static class a extends ab<ViewGroup> {
    public l ctC = new l(2131297727);
    
    public l ctD = new l(2131297513);
    
    public l ctE = new l(2131297615);
    
    public l ctF = new l(2131297618);
    
    public ab<TextView> ctl = new ab(2131299820);
    
    public ab<TextView> ctp = new ab(2131299623);
    
    public ab<TextView> ctr = new ab(2131299561);
    
    public ab<TextView> cts = new ab(2131299560);
    
    public a(int param1Int) { super(param1Int); }
    
    public static a x(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427432, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\TakeOutPaymentSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */