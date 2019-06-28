package com.laiqian.pos.industry.weiorder;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.network.o;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.f;
import com.laiqian.ui.container.m;
import com.laiqian.ui.s;
import com.laiqian.util.ar;
import com.laiqian.util.n;
import java.util.concurrent.FutureTask;

public class QrorderMarketingFragment extends FragmentRoot implements ag, g {
  private r bCE;
  
  private r bCF;
  
  a csK;
  
  ad csL;
  
  private Handler mHandler = new t(this);
  
  private bb mWaitingDialog;
  
  aa titleBar;
  
  private void RD() {
    this.mHandler.obtainMessage(3).sendToTarget();
    try {
      o.WQ().a(new FutureTask(new s(this), null));
      return;
    } catch (InterruptedException interruptedException) {
      a.e(interruptedException);
      return;
    } 
  }
  
  private boolean abd() {
    if (TextUtils.isEmpty(((EditText)this.csK.bFT.dwQ.getView()).getText().toString())) {
      showError(getString(2131629974));
      return false;
    } 
    try {
      double d = n.u(((EditText)this.csK.bFT.dwQ.getView()).getText().toString());
      if (getContext().getResources().getBoolean(2131034121) ? (d < 0.0D || d >= 100.0D) : (d <= 0.0D || d > 100.0D)) {
        showError(getString(2131629970));
        return false;
      } 
      this.csL.p(d);
      return true;
    } catch (Exception exception) {
      a.e(exception);
      return false;
    } 
  }
  
  private void setListeners() {
    this.bCE.a(new n(this));
    this.bCF.a(new v(this));
    ((EditText)this.csK.bFT.dwQ.getView()).addTextChangedListener(new w(this));
    ((ViewGroup)this.csK.csU.getView()).setOnClickListener(new x(this));
    ((ViewGroup)this.csK.csV.getView()).setOnClickListener(new y(this));
    ((ViewGroup)this.csK.csW.getView()).setOnClickListener(new z(this));
    ((CheckBox)this.csK.csW.dwV.getView()).setOnCheckedChangeListener(new aa(this));
    ((CheckBox)this.csK.csU.dwV.getView()).setOnCheckedChangeListener(new ab(this));
    ((CheckBox)this.csK.csV.dwV.getView()).setOnCheckedChangeListener(new ac(this));
    ((CheckBox)this.csK.csR.dwV.getView()).setOnCheckedChangeListener(new o(this));
    ((CheckBox)this.csK.csS.dwV.getView()).setOnCheckedChangeListener(new p(this));
    ((ViewGroup)this.csK.csR.getView()).setOnClickListener(new q(this));
    ((ViewGroup)this.csK.csS.getView()).setOnClickListener(new r(this));
  }
  
  private void setupViews() {
    this.mWaitingDialog = new bb(getActivity());
    this.mWaitingDialog.setCancelable(false);
    this.bCE = new r(getActivity(), true, null);
    this.bCE.oZ("取消");
    this.bCE.t("开启");
    this.bCE.setTitle(getString(2131626722));
    this.bCE.s(getString(2131626016));
    this.bCF = new r(getActivity(), true, null);
    this.bCF.oZ("取消");
    this.bCF.t("重试");
    this.bCF.setTitle(getString(2131626722));
    this.bCF.s("上传数据失败,请检查网络");
    ((ViewGroup)this.csK.csV.getView()).setVisibility(0);
    ((ViewGroup)this.csK.csU.getView()).setVisibility(0);
    ((TextView)this.csK.csT.getView()).setText(getString(2131629983));
    ((TextView)this.csK.csO.getView()).setText(getString(2131626053));
    ((TextView)this.csK.csP.getView()).setText(getString(2131626057));
    ((TextView)this.csK.csQ.getView()).setText(2131630383);
    ((TextView)this.csK.csR.cAO.getView()).setText(getString(2131626054));
    ((TextView)this.csK.csU.cAO.getView()).setText(getString(2131626052));
    ((TextView)this.csK.csS.cAO.getView()).setText(getString(2131626054));
    ((TextView)this.csK.csV.cAO.getView()).setText(getString(2131626056));
    ((TextView)this.csK.bFT.cAO.getView()).setText(getString(2131629981));
    ((TextView)this.csK.csW.cAO.getView()).setText(getString(2131630384));
    ((TextView)this.csK.bFT.cAT.getView()).setText("%");
    ((EditText)this.csK.bFT.dwQ.getView()).setInputType(8194);
    ((EditText)this.csK.bFT.dwQ.getView()).setFilters(ar.bE(3, 2));
    ((ViewGroup)this.csK.csR.getView()).setBackgroundResource(2130772057);
    ((ViewGroup)this.csK.csS.getView()).setBackgroundResource(2130772057);
    ((ViewGroup)this.csK.csU.getView()).setBackgroundResource(2130772051);
    ((ViewGroup)this.csK.csV.getView()).setBackgroundResource(2130772051);
    ((ViewGroup)this.csK.bFT.getView()).setBackgroundResource(2130772052);
    ((ViewGroup)this.csK.csW.getView()).setBackgroundResource(2130772052);
    if (a.zR().Ad()) {
      ((ViewGroup)this.csK.csR.getView()).setVisibility(8);
      ((ViewGroup)this.csK.csS.getView()).setVisibility(8);
      ((TextView)this.csK.csO.getView()).setVisibility(8);
      ((TextView)this.csK.csT.getView()).setVisibility(8);
      ((TextView)this.csK.csP.getView()).setVisibility(8);
      ((ViewGroup)this.csK.csU.getView()).setVisibility(8);
      ((ViewGroup)this.csK.csV.getView()).setVisibility(8);
    } 
  }
  
  public boolean Az() { return (this.csL != null) ? this.csL.Az() : 0; }
  
  public void Em() {
    this.csK.aNv.setVisibility(0);
    this.csK.bDV.setVisibility(8);
  }
  
  public void RA() {
    if (this.titleBar != null) {
      this.titleBar.brk.setVisibility(0);
      this.titleBar.aNv.setVisibility(8);
    } 
  }
  
  public void Rz() {
    if (this.titleBar != null) {
      this.titleBar.brk.setVisibility(8);
      this.titleBar.aNv.setVisibility(0);
    } 
  }
  
  public void a(aa paramaa) {
    this.titleBar = paramaa;
    if (abd())
      this.csL.save(); 
  }
  
  public void cE(boolean paramBoolean) { ((CheckBox)this.csK.csW.dwV.getView()).setChecked(paramBoolean); }
  
  public void cF(boolean paramBoolean) { ((CheckBox)this.csK.csR.dwV.getView()).setChecked(paramBoolean); }
  
  public void cG(boolean paramBoolean) { ((CheckBox)this.csK.csS.dwV.getView()).setChecked(paramBoolean); }
  
  public void eZ(boolean paramBoolean) { ((CheckBox)this.csK.csU.dwV.getView()).setChecked(paramBoolean); }
  
  public void fa(boolean paramBoolean) { ((CheckBox)this.csK.csV.dwV.getView()).setChecked(paramBoolean); }
  
  public void hideProgress() {
    this.csK.aNv.setVisibility(8);
    this.csK.bDV.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.csL = new ad(getActivity(), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.csK = a.l(this);
    this.csL.init();
    setupViews();
    setListeners();
    return this.csK.getView();
  }
  
  public void p(double paramDouble) {
    EditText editText = (EditText)this.csK.bFT.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(paramDouble);
    editText.setText(stringBuilder.toString());
  }
  
  public void q(String paramString, boolean paramBoolean) {}
  
  public void r(String paramString, boolean paramBoolean) {}
  
  public void save() {
    if (abd())
      this.csL.save(); 
  }
  
  public void showError(String paramString) {
    if (getActivity() != null)
      Toast.makeText(getActivity(), paramString, 0).show(); 
  }
  
  public static class a extends ab<ViewGroup> {
    public ProgressBarCircularIndeterminate aNv;
    
    public ViewGroup bDV;
    
    public f bFT = new f(2131297556);
    
    public ab<TextView> csO = new ab(2131299472);
    
    public ab<TextView> csP = new ab(2131299821);
    
    public ab<TextView> csQ = new ab(2131299815);
    
    public m csR = new m(2131297609);
    
    public m csS = new m(2131297610);
    
    public ab<TextView> csT = new ab(2131299582);
    
    public m csU = new m(2131297611);
    
    public m csV = new m(2131297612);
    
    public m csW = new m(2131297719);
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.aNv = (ProgressBarCircularIndeterminate)s.z(param1View, 2131297346);
      this.bDV = (ViewGroup)s.z(param1View, 2131297905);
    }
    
    public static a l(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(2131427604, null);
      if (view == null)
        throw new IllegalStateException("view cannot be null, inflate error"); 
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\QrorderMarketingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */