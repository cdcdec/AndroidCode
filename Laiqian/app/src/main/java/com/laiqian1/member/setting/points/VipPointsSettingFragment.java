package com.laiqian.member.setting.points;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.f;
import com.laiqian.ui.container.l;
import com.laiqian.ui.s;
import com.laiqian.util.ar;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.vip.R;

public class VipPointsSettingFragment extends Fragment implements j, aa {
  h bFA;
  
  a bFz;
  
  aa titleBar;
  
  private void RX() {
    ((ViewGroup)this.bFz.bFE.getView()).setFocusableInTouchMode(true);
    ((ViewGroup)this.bFz.bFE.getView()).setFocusable(true);
    ((ViewGroup)this.bFz.bFE.getView()).requestFocus();
  }
  
  public boolean Az() { return (this.bFA != null) ? this.bFA.Az() : 0; }
  
  public void C(Boolean paramBoolean) {
    int i;
    ViewGroup viewGroup = (ViewGroup)this.bFz.bFD.getView();
    if (paramBoolean.booleanValue()) {
      i = R.drawable.shape_rounded_rectangle_up_click;
    } else {
      i = R.drawable.shape_rounded_rectangle_only_click;
    } 
    viewGroup.setBackgroundResource(i);
    ((CheckBox)this.bFz.bFD.dwV.getView()).setChecked(paramBoolean.booleanValue());
    viewGroup = (ViewGroup)this.bFz.bFC.getView();
    if (paramBoolean.booleanValue()) {
      i = 0;
    } else {
      i = 8;
    } 
    viewGroup.setVisibility(i);
  }
  
  public void Em() {
    this.bFz.aNv.setVisibility(0);
    this.bFz.bDV.setVisibility(8);
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
  
  public boolean SH() {
    String str1 = ((EditText)this.bFz.bFC.dwQ.getView()).getText().toString().trim();
    if (by.isNull(str1)) {
      Toast.makeText(getActivity(), R.string.pos_vip_credit_points_ratio_not_empty, 1).show();
      ((EditText)this.bFz.bFC.dwQ.getView()).requestFocus();
      return false;
    } 
    if (Double.valueOf(str1).doubleValue() <= 0.0D) {
      Toast.makeText(getActivity(), R.string.pos_vip_credit_points_ratio_not_empty_zero, 1).show();
      ((EditText)this.bFz.bFC.dwQ.getView()).requestFocus();
      return false;
    } 
    str1 = this.bFz.bFF.getText().toString().trim();
    String str2 = this.bFz.bFG.getText().toString().trim();
    if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2) || n.pl(str1) || n.pl(str2)) {
      Toast.makeText(getActivity(), R.string.pos_vip_credit_points_rule_not_empty_zero, 1).show();
      return false;
    } 
    return true;
  }
  
  public void a(aa paramaa) {
    this.titleBar = paramaa;
    if (SH()) {
      this.bFA.save();
      RX();
      n.R(getActivity());
    } 
  }
  
  public void b(a parama) {
    if (zP()) {
      setupViews();
      eb(parama.SE());
      C(Boolean.valueOf(parama.SB()));
      ea(parama.SE());
      fV(parama.SA());
      c(new Pair(Double.valueOf(parama.SC()), Double.valueOf(parama.SD())));
      setListeners();
    } 
  }
  
  public void c(Pair<Double, Double> paramPair) {
    this.bFz.bFF.setText(n.ba(((Double)paramPair.first).doubleValue()));
    this.bFz.bFG.setText(n.ba(((Double)paramPair.second).doubleValue()));
  }
  
  public void ea(boolean paramBoolean) {
    byte b;
    ((CheckBox)this.bFz.bFE.dwV.getView()).setChecked(paramBoolean);
    ViewGroup viewGroup = (ViewGroup)this.bFz.bFD.getView();
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    viewGroup.setVisibility(b);
  }
  
  public void eb(boolean paramBoolean) {
    byte b;
    View view = this.bFz.bFH;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    view.setVisibility(b);
  }
  
  public void fV(int paramInt) {
    EditText editText = (EditText)this.bFz.bFC.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
  }
  
  public void hideProgress() {
    this.bFz.aNv.setVisibility(8);
    this.bFz.bDV.setVisibility(0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.bFz = a.g(this);
    this.bFA = new h(getActivity(), this);
    return this.bFz.getView();
  }
  
  public void onStart() {
    super.onStart();
    this.bFA.init();
  }
  
  public void save() {
    if (SH()) {
      this.bFA.save();
      RX();
      n.R(getActivity());
    } 
  }
  
  public void setListeners() {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      this.bFz.bFF.setEnabled(false);
      this.bFz.bFG.setEnabled(false);
      this.bFz.bFI.setOnClickListener(b.bBU);
    } else {
      this.bFz.bFF.addTextChangedListener(new c(this));
      this.bFz.bFG.addTextChangedListener(new d(this));
    } 
    ((CheckBox)this.bFz.bFD.dwV.getView()).setOnCheckedChangeListener(new e(this));
    ((CheckBox)this.bFz.bFE.dwV.getView()).setOnCheckedChangeListener(new f(this));
    ((EditText)this.bFz.bFC.dwQ.getView()).addTextChangedListener(new g(this));
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
      ((EditText)this.bFz.bFC.dwQ.getView()).setEnabled(false); 
  }
  
  public void setupViews() {
    ((TextView)this.bFz.bFC.cAO.getView()).setText(getString(R.string.pos_vip_credit_points_ratio));
    ((TextView)this.bFz.bFC.cAT.getView()).setText(getString(R.string.pos_vip_credit_points_ratio_context));
    ((TextView)this.bFz.bFC.cAT.getView()).setTextColor(getResources().getColor(R.color.notEditable_edittext_value_txt));
    ((EditText)this.bFz.bFC.dwQ.getView()).setInputType(8194);
    ((EditText)this.bFz.bFC.dwQ.getView()).setFilters(ar.bE(5, 0));
    ((TextView)this.bFz.bFD.cAO.getView()).setText(getString(R.string.pos_vip_credit_points_enable));
    ((TextView)this.bFz.bFE.cAO.getView()).setText(getString(R.string.pos_vip_switch_points_enable));
    ((ViewGroup)this.bFz.bFD.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((ViewGroup)this.bFz.bFE.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    ((ViewGroup)this.bFz.bFC.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
  }
  
  public void showError(String paramString) { Toast.makeText(getActivity(), paramString, 0).show(); }
  
  public boolean zP() { return isAdded(); }
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.fragment_vip_points_setting;
    
    public ProgressBarCircularIndeterminate aNv;
    
    public ViewGroup bDV;
    
    public f bFC = new f(R.id.layoutCreditRatio);
    
    public l bFD = new l(R.id.layoutCreditPoints);
    
    public l bFE = new l(R.id.layout_enable_integration);
    
    public EditText bFF;
    
    public EditText bFG;
    
    public View bFH;
    
    public View bFI;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.aNv = (ProgressBarCircularIndeterminate)s.z(param1View, R.id.ivProgress);
      this.bDV = (ViewGroup)s.z(param1View, R.id.llContent);
      this.bFI = s.z(param1View, R.id.et_rule);
      this.bFF = (EditText)s.z(param1View, R.id.point_numerator);
      n.a(this.bFF, 20, a.AZ().Be());
      this.bFG = (EditText)s.z(param1View, R.id.point_denominator);
      n.a(this.bFG, 20, a.AZ().Be());
      this.bFH = s.z(param1View, R.id.ll_autoUpgrade_rule);
    }
    
    public static a g(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(aCt, null);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\points\VipPointsSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */