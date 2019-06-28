package com.laiqian.member.setting.discount;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.g;
import com.laiqian.member.setting.as;
import com.laiqian.models.at;
import com.laiqian.network.o;
import com.laiqian.pos.settings.aa;
import com.laiqian.sync.a.g;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.l;
import com.laiqian.ui.s;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.List;
import java.util.concurrent.FutureTask;

public class VipSettingFragment extends Fragment implements as, aa {
  private r bCE;
  
  private r bCF;
  
  v bDK;
  
  private boolean bDN;
  
  a bDX;
  
  List<g> bDY;
  
  private boolean isDiscountConvertion;
  
  private Handler mHandler = new x(this);
  
  private bb mWaitingDialog;
  
  aa titleBar;
  
  private void RD() {
    this.mHandler.obtainMessage(3).sendToTarget();
    try {
      g g = new g(getActivity());
      o.WQ().a(new FutureTask(new w(this, g), null));
      return;
    } catch (InterruptedException interruptedException) {
      a.e(interruptedException);
      return;
    } 
  }
  
  private void RE() {
    this.bCE = new r(getActivity(), true, null);
    this.bCE.oZ("取消");
    this.bCE.t("开启");
    this.bCE.setTitle(getString(R.string.pos_dialog_title_prompt));
    this.bCE.s(n.d(getActivity(), "打开后,会员相关功能都需", "联网", "操作,推荐多收银机使用"));
    this.mWaitingDialog = new bb(getActivity());
    this.mWaitingDialog.setCancelable(false);
    this.bCF = new r(getActivity(), true, null);
    this.bCF.oZ("取消");
    this.bCF.t("重试");
    this.bCF.setTitle(getString(R.string.pos_dialog_title_prompt));
    this.bCF.s("上传数据失败,请检查网络");
    r r1 = new r(getActivity(), true, null);
    r1.setTitle(getString(R.string.pos_dialog_title_prompt));
    r1.s(getString(R.string.member_online_switch_dialog_prompt));
    r1.arm().setText(getString(R.string.pos_dialog_confirm_no));
    r1.arn().setText(R.string.member_online_switch_dialog_open);
  }
  
  private void dR(boolean paramBoolean) { ((CheckBox)this.bDX.bEb.dwV.getView()).setChecked(paramBoolean); }
  
  private void dY(boolean paramBoolean) { ((CheckBox)this.bDX.bEc.dwV.getView()).setChecked(paramBoolean); }
  
  private void initData() {
    this.isDiscountConvertion = getResources().getBoolean(R.bool.is_DiscountConvertion);
    at at = new at(getActivity());
    this.bDY = at.RJ();
    at.close();
    z(Boolean.valueOf(a.AZ().Bu()));
    dR(a.AZ().Bw());
    if (this.bDN)
      dY(RootApplication.getLaiqianPreferenceManager().Wq()); 
  }
  
  private void setListeners() {
    this.bCF.a(new y(this));
    this.bCE.a(new z(this));
    ((CheckBox)this.bDX.bEa.dwV.getView()).setOnCheckedChangeListener(new aa(this));
    ((CheckBox)this.bDX.bEb.dwV.getView()).setOnCheckedChangeListener(new ab(this));
    if (this.bDN) {
      ((CheckBox)this.bDX.bEc.dwV.getView()).setClickable(false);
      ((ViewGroup)this.bDX.bEc.getView()).setOnClickListener(new ac(this));
    } 
  }
  
  private void setupViews() {
    ((TextView)this.bDX.bEa.cAO.getView()).setText(getString(R.string.membership_allows_negative_values));
    ((ViewGroup)this.bDX.bEa.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((TextView)this.bDX.bEb.cAO.getView()).setText(getString(R.string.member_only_read_card));
    ((ViewGroup)this.bDX.bEb.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      ((ViewGroup)this.bDX.bEa.getView()).setVisibility(8);
      a.AZ().bN(false);
      ((ViewGroup)this.bDX.bEb.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 80);
      layoutParams.setMargins(0, 12, 0, 0);
      ((ViewGroup)this.bDX.bEb.getView()).setLayoutParams(layoutParams);
    } 
    if (a.zR().zW()) {
      ((ViewGroup)this.bDX.bEa.getView()).setVisibility(8);
      ((ViewGroup)this.bDX.bEb.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 80);
      layoutParams.setMargins(0, 12, 0, 0);
      ((ViewGroup)this.bDX.bEb.getView()).setLayoutParams(layoutParams);
    } 
    if (this.bDN) {
      ((TextView)this.bDX.bEc.cAO.getView()).setText(R.string.member_online_switch);
      ((ViewGroup)this.bDX.bEc.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
      return;
    } 
    ((ViewGroup)this.bDX.bEc.getView()).setVisibility(8);
  }
  
  private void z(Boolean paramBoolean) { ((CheckBox)this.bDX.bEa.dwV.getView()).setChecked(paramBoolean.booleanValue()); }
  
  public boolean Az() { return false; }
  
  public void Em() {}
  
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
    this.bDK.dT(true);
  }
  
  public void hideProgress() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 != -1)
      return; 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.bDX = a.e(this);
    this.bDK = new v(getActivity(), this);
    if (RootApplication.getLaiqianPreferenceManager().QV() == 0 && !a.zR().Ab() && !a.zR().Ad())
      this.bDN = true; 
    setupViews();
    initData();
    RE();
    setListeners();
    return this.bDX.getView();
  }
  
  public void onResume() { super.onResume(); }
  
  public void save() { this.bDK.dT(true); }
  
  public void showError(String paramString) { n.o(paramString); }
  
  public boolean zP() { return isAdded(); }
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.fragment_vip_setting;
    
    public ViewGroup bDV;
    
    public l bEa = new l(R.id.layoutVipOnCredit);
    
    public l bEb = new l(R.id.only_read_card_layout);
    
    public l bEc = new l(R.id.online_vip);
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.bDV = (ViewGroup)s.z(param1View, R.id.llContent);
    }
    
    public static a e(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(aCt, null);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\VipSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */