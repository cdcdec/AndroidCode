package com.laiqian.pos.industry.weiorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.ab;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.d;
import com.laiqian.ui.container.f;
import com.laiqian.util.ar;
import java.util.ArrayList;

public class TakeOutMarketingActivity extends ActivityRoot implements ar {
  a cth;
  
  ap cti;
  
  ArrayList<eh> ctj;
  
  aa titleBar;
  
  private boolean abd() {
    String str = ((EditText)this.cth.ctm.dwQ.getView()).getText().toString();
    if (TextUtils.isEmpty(str)) {
      Toast.makeText(this, getString(2131629975), 0).show();
      return false;
    } 
    this.cti.az(Double.parseDouble(str));
    str = ((EditText)this.cth.cto.dwQ.getView()).getText().toString();
    if (TextUtils.isEmpty(str)) {
      Toast.makeText(this, getString(2131629976), 0).show();
      return false;
    } 
    double d = Double.parseDouble(str);
    if (d < 0.0D || d > 100.0D) {
      Toast.makeText(this, getString(2131629970), 0).show();
      return false;
    } 
    this.cti.aA(d);
    str = ((EditText)this.cth.ctq.dwQ.getView()).getText().toString();
    if (TextUtils.isEmpty(str)) {
      Toast.makeText(this, getString(2131629974), 0).show();
      return false;
    } 
    d = Double.parseDouble(str);
    if (d < 0.0D || d > 100.0D) {
      Toast.makeText(this, getString(2131629970), 0).show();
      return false;
    } 
    this.cti.aB(d);
    return true;
  }
  
  private void abi() {
    r r = new r(this, new ao(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  private void setListeners() {
    this.titleBar.bri.setOnClickListener(new al(this));
    this.titleBar.brj.setOnClickListener(new am(this));
    ((RelativeLayout)this.cth.ctn.getView()).setOnClickListener(new an(this));
  }
  
  private void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131629983));
    this.titleBar.brj.setText(getString(2131629495));
    this.titleBar.brk.setVisibility(8);
    ((TextView)this.cth.ctl.getView()).setText(getString(2131629985));
    ((TextView)this.cth.ctp.getView()).setText(getString(2131627171));
    ((TextView)this.cth.ctm.cAO.getView()).setText(2131630553);
    ((TextView)this.cth.ctm.cAT.getView()).setText(2131624910);
    ((TextView)this.cth.ctn.cAO.getView()).setText(getString(2131630550));
    ((TextView)this.cth.cto.cAO.getView()).setText(getString(2131629984));
    ((TextView)this.cth.cto.cAT.getView()).setText("%");
    ((TextView)this.cth.ctq.cAT.getView()).setText("%");
    ((TextView)this.cth.ctq.cAO.getView()).setText(getString(2131629981));
    ((TextView)this.cth.ctr.getView()).setText(getString(2131629980));
    ((TextView)this.cth.cts.getView()).setText(getString(2131629979));
    ((EditText)this.cth.ctm.dwQ.getView()).setInputType(8194);
    ((EditText)this.cth.cto.dwQ.getView()).setInputType(8194);
    ((EditText)this.cth.ctq.dwQ.getView()).setInputType(8194);
    ((EditText)this.cth.cto.dwQ.getView()).setFilters(ar.bE(3, 2));
    ((EditText)this.cth.ctq.dwQ.getView()).setFilters(ar.bE(3, 2));
  }
  
  public void Em() { ab.N(this); }
  
  public void aA(double paramDouble) {
    EditText editText = (EditText)this.cth.cto.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
  }
  
  public void aB(double paramDouble) {
    EditText editText = (EditText)this.cth.ctq.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
  }
  
  public void af(ArrayList<eh> paramArrayList) { this.ctj = paramArrayList; }
  
  public void az(double paramDouble) {
    EditText editText = (EditText)this.cth.ctm.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
  }
  
  public void exit() { finish(); }
  
  public void hideProgress() { ab.P(this); }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 1)
        return; 
      ArrayList arrayList = (ArrayList)paramIntent.getSerializableExtra("couponList");
      this.cti.af(arrayList);
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cth = a.w(this);
    this.titleBar = aa.M(this);
    this.cti = new ap(this, this);
    this.cti.init();
    setupViews();
    setListeners();
  }
  
  public void save() {
    if (abd())
      this.cti.save(); 
  }
  
  public void showError(String paramString) { Toast.makeText(getActivity(), paramString, 0).show(); }
  
  public static class a extends ab<ViewGroup> {
    public ab<TextView> ctl = new ab(2131299820);
    
    public f ctm = new f(2131297691);
    
    public d ctn = new d(2131297538);
    
    public f cto = new f(2131297725);
    
    public ab<TextView> ctp = new ab(2131299623);
    
    public f ctq = new f(2131297617);
    
    public ab<TextView> ctr = new ab(2131299561);
    
    public ab<TextView> cts = new ab(2131299560);
    
    public a(int param1Int) { super(param1Int); }
    
    public static a w(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427431, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\TakeOutMarketingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */