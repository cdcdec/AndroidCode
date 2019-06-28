package com.laiqian.member.setting.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.member.setting.marketing.a.a;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.l;
import com.laiqian.ui.container.m;
import com.laiqian.ui.layout.CheckBoxLayout;
import com.laiqian.ui.s;
import com.laiqian.util.by;
import com.laiqian.vip.R;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;

public class SmsSettingFragment extends Fragment implements v, aa {
  a bGO;
  
  t bGP;
  
  private SmsReceiver bGQ;
  
  aa titleBar;
  
  private void Lk() {
    if (this.bGQ == null)
      this.bGQ = new SmsReceiver(this); 
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("SMS_CHARGE_RECEIVER");
    getActivity().registerReceiver(this.bGQ, intentFilter);
  }
  
  private void Ll() {
    try {
      getActivity().unregisterReceiver(this.bGQ);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  public static SmsSettingFragment ST() {
    Bundle bundle = new Bundle();
    SmsSettingFragment smsSettingFragment = new SmsSettingFragment();
    smsSettingFragment.setArguments(bundle);
    return smsSettingFragment;
  }
  
  private void setListeners() {
    ((ViewGroup)this.bGO.bGT.getView()).setOnClickListener(new l(this));
    ((ViewGroup)this.bGO.bGU.getView()).setOnClickListener(new m(this));
    ((CheckBox)this.bGO.bGS.dwV.getView()).setOnCheckedChangeListener(new n(this));
    ((ViewGroup)this.bGO.bEF.getView()).setOnClickListener(new o(this));
    this.bGO.bGV.a(new p(this));
    this.bGO.bGW.a(new q(this));
    this.bGO.bGX.a(new r(this));
    this.bGO.bqN.setOnClickListener(new s(this));
  }
  
  private void setupViews() {
    ((TextView)this.bGO.bGS.cAO.getView()).setText(R.string.vip_sms_label);
    ((ViewGroup)this.bGO.bGS.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ViewGroup.LayoutParams layoutParams = ((TextView)this.bGO.bEF.cAO.getView()).getLayoutParams();
    layoutParams.width = 300;
    ((TextView)this.bGO.bEF.cAO.getView()).setLayoutParams(layoutParams);
    ((TextView)this.bGO.bEF.dwP.getView()).setText(R.string.vip_buy_sms);
    ((ViewGroup)this.bGO.bEF.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    ((TextView)this.bGO.bGT.cAO.getView()).setLayoutParams(layoutParams);
    ((TextView)this.bGO.bGT.cAO.getView()).setText(R.string.vip_sms_create);
    ((TextView)this.bGO.bGT.dwP.getView()).setText(R.string.vip_sms_promotion_example);
    ((ViewGroup)this.bGO.bGT.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((TextView)this.bGO.bGU.cAO.getView()).setLayoutParams(layoutParams);
    ((TextView)this.bGO.bGU.cAO.getView()).setText(R.string.vip_sms_statics_detail);
    ((ViewGroup)this.bGO.bGU.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    this.bGO.bGV.setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    this.bGO.bGW.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    this.bGO.bGX.setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
  }
  
  public boolean Az() { return (this.bGP != null) ? this.bGP.Az() : 0; }
  
  public void Em() {
    this.bGO.aNv.setVisibility(0);
    this.bGO.bEJ.setVisibility(8);
    this.bGO.bqN.setVisibility(8);
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
  
  public void Sl() {
    this.bGO.bqN.setVisibility(0);
    this.bGO.aNv.setVisibility(8);
    this.bGO.bEJ.setVisibility(8);
  }
  
  public void a(aa paramaa) {
    this.titleBar = paramaa;
    this.bGP.save();
  }
  
  public void ec(boolean paramBoolean) {
    byte b;
    ((CheckBox)this.bGO.bGS.dwV.getView()).setChecked(paramBoolean);
    ViewGroup viewGroup = this.bGO.bGY;
    if (paramBoolean == true) {
      b = 0;
    } else {
      b = 8;
    } 
    viewGroup.setVisibility(b);
  }
  
  public void ed(boolean paramBoolean) { this.bGO.bGV.setChecked(paramBoolean); }
  
  public void ee(boolean paramBoolean) { this.bGO.bGW.setChecked(paramBoolean); }
  
  public void ef(boolean paramBoolean) { this.bGO.bGX.setChecked(paramBoolean); }
  
  public void fS(int paramInt) {
    SpannableString spannableString = by.b(String.format(getResources().getString(R.string.vip_sms_quantity_left), new Object[] { Integer.valueOf(paramInt) }), String.valueOf(paramInt), 18, getResources().getColor(R.color.setting_text_color3));
    ((TextView)this.bGO.bEF.cAO.getView()).setText(spannableString);
  }
  
  public void hideProgress() {
    this.bGO.aNv.setVisibility(8);
    this.bGO.bEJ.setVisibility(0);
    this.bGO.bqN.setVisibility(0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    if (!c.aYt().cK(this))
      c.aYt().cJ(this); 
    this.bGO = a.h(this);
    Lk();
    this.bGP = new t(getActivity(), this);
    this.bGP.init();
    setupViews();
    setListeners();
    return this.bGO.getView();
  }
  
  public void onDestroy() {
    if (c.aYt().cK(this))
      c.aYt().cL(this); 
    Ll();
    super.onDestroy();
  }
  
  public void save() { this.bGP.save(); }
  
  public void showError(String paramString) { Toast.makeText(getActivity(), paramString, 0).show(); }
  
  @Subscribe(aYx = ThreadMode.MAIN)
  public void updateSMSQuantity(a parama) { fS(parama.Sz()); }
  
  public void zO() {
    this.bGO.bqN.setVisibility(8);
    this.bGO.aNv.setVisibility(8);
    this.bGO.bEJ.setVisibility(0);
  }
  
  public boolean zP() { return isAdded(); }
  
  public class SmsReceiver extends BroadcastReceiver {
    public SmsReceiver(SmsSettingFragment this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      int i = param1Intent.getIntExtra("SMS_QUANTITY_LEFT", 0);
      this.bGR.fS(i);
      this.bGR.bGP.fS(i);
    }
  }
  
  static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.fragment_vip_sms_setting;
    
    public ProgressBarCircularIndeterminate aNv;
    
    public m bEF = new m(R.id.layout_sms);
    
    public ViewGroup bEJ;
    
    public l bGS = new l(R.id.layout_sms_switch);
    
    public m bGT = new m(R.id.layout_create_sms);
    
    public m bGU = new m(R.id.layout_sms_statics_detail);
    
    public CheckBoxLayout bGV;
    
    public CheckBoxLayout bGW;
    
    public CheckBoxLayout bGX;
    
    public ViewGroup bGY;
    
    public ViewGroup bqN;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.aNv = (ProgressBarCircularIndeterminate)s.z(param1View, R.id.ivProgress);
      this.bEJ = (ViewGroup)s.z(param1View, R.id.llContent);
      this.bGY = (ViewGroup)s.z(param1View, R.id.ll_detail);
      this.bGV = (CheckBoxLayout)s.z(param1View, R.id.cb_consume_sms);
      this.bGW = (CheckBoxLayout)s.z(param1View, R.id.cb_charge_sms);
      this.bGX = (CheckBoxLayout)s.z(param1View, R.id.cb_wechat_code_sms);
      this.bqN = (ViewGroup)s.z(param1View, R.id.llRefresh);
    }
    
    public static a h(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(aCt, null);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\SmsSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */