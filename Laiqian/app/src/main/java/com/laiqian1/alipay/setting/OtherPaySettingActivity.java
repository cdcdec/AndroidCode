package com.laiqian.alipay.setting;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.payment.R;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.AbstractActivity;

public class OtherPaySettingActivity extends AbstractActivity implements c {
  r.a aCA = new e(this);
  
  View.OnClickListener aCB = new m(this);
  
  private a aCf = new a(this, this);
  
  private n aCy = new n(R.id.linerlayout_alipay_content);
  
  private r aCz;
  
  private void bB(View paramView) { paramView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.call_send_view_exit)); }
  
  private void bC(View paramView) { paramView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.call_send_view_enter)); }
  
  private void bD(View paramView) { paramView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.call_send_view_right_enter)); }
  
  private void bE(View paramView) { paramView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.call_send_view_right_exit)); }
  
  private void bF(View paramView) { paramView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.relativelayout_hide_animation)); }
  
  private void bG(View paramView) { paramView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.relativelayout_show_animation)); }
  
  private void setListeners() {
    ((Button)this.aCy.aCJ.getView()).setOnClickListener(new f(this));
    ((RelativeLayout)this.aCy.aCG.getView()).setOnClickListener(new g(this));
    ((RelativeLayout)this.aCy.aCu.getView()).setOnClickListener(new h(this));
    ((RelativeLayout)this.aCy.aCH.getView()).setOnClickListener(new i(this));
    ((RelativeLayout)this.aCy.aCD.getView()).setOnClickListener(new j(this));
    ((RelativeLayout)this.aCy.aCE.getView()).setOnClickListener(new k(this));
    ((RelativeLayout)this.aCy.aCF.getView()).setOnClickListener(new l(this));
  }
  
  private void wR() {
    ((ImageView)this.aCy.aCG.aCw.getView()).setImageResource(R.drawable.pos_pay_alipay_barcode);
    ((ImageView)this.aCy.aCu.aCw.getView()).setImageResource(R.drawable.pos_pay_alipay_qrcode);
    ((ImageView)this.aCy.aCH.aCw.getView()).setImageResource(R.drawable.pos_pay_account);
    ((ImageView)this.aCy.aCD.aCw.getView()).setImageResource(R.drawable.pos_pay_meituan);
    ((ImageView)this.aCy.aCE.aCw.getView()).setImageResource(R.drawable.pos_pay_dzdp);
    ((ImageView)this.aCy.aCF.aCw.getView()).setImageResource(R.drawable.pos_pay_dp);
    a(this.aCy.aCG.aCv, getString(R.string.pos_alipay_barcode_title));
    a(this.aCy.aCu.aCv, getString(R.string.pos_alipay_qrcode_title));
    a(this.aCy.aCH.aCv, getString(R.string.pos_alipay_account_title));
    a(this.aCy.aCD.aCv, getString(R.string.pos_pay_type_alipay_meituan_coupons));
    a(this.aCy.aCE.aCv, getString(R.string.pos_pay_type_alipay_dzdp_coupons));
    a(this.aCy.aCF.aCv, getString(R.string.pos_pay_type_alipay_dp_coupons));
  }
  
  private void xC() {
    if (this.aCf.xB()) {
      System.out.println("change");
      this.aCz = new r(this, true, this.aCA);
      this.aCz.setTitle(getString(R.string.pos_quit_save_hint_dialog_title));
      this.aCz.s(getString(R.string.pos_quit_save_hint_dialog_msg));
      this.aCz.t(getString(R.string.pos_quit_save_hint_dialog_sure));
      this.aCz.oZ(getString(R.string.pos_quit_save_hint_dialog_cancel));
      this.aCz.show();
      return;
    } 
    finish();
  }
  
  public boolean beforeCloseActivity() {
    xC();
    return true;
  }
  
  public void bu(boolean paramBoolean) {
    if (paramBoolean) {
      this.aCy.aCG.aCx.getView().setVisibility(0);
      ((LinearLayout)this.aCy.aCI.getView()).setVisibility(0);
      return;
    } 
    this.aCy.aCG.aCx.getView().setVisibility(8);
    ((LinearLayout)this.aCy.aCI.getView()).setVisibility(8);
  }
  
  public void bv(boolean paramBoolean) {
    if (paramBoolean) {
      this.aCy.aCu.aCx.getView().setVisibility(0);
      ((TextView)this.aCy.aCK.getView()).setVisibility(0);
      return;
    } 
    this.aCy.aCu.aCx.getView().setVisibility(8);
    ((TextView)this.aCy.aCK.getView()).setVisibility(8);
  }
  
  public void bw(boolean paramBoolean) {
    if (paramBoolean) {
      this.aCy.aCD.aCx.getView().setVisibility(0);
      return;
    } 
    this.aCy.aCD.aCx.getView().setVisibility(8);
  }
  
  public void bx(boolean paramBoolean) {
    if (paramBoolean) {
      this.aCy.aCE.aCx.getView().setVisibility(0);
      return;
    } 
    this.aCy.aCE.aCx.getView().setVisibility(8);
  }
  
  public void by(boolean paramBoolean) {
    if (paramBoolean) {
      this.aCy.aCF.aCx.getView().setVisibility(0);
      return;
    } 
    this.aCy.aCF.aCx.getView().setVisibility(8);
  }
  
  public void bz(boolean paramBoolean) {
    if (paramBoolean) {
      this.aCy.aCH.aCx.getView().setVisibility(0);
      ((TextView)this.aCy.aCL.getView()).setVisibility(0);
      return;
    } 
    this.aCy.aCH.aCx.getView().setVisibility(8);
    ((TextView)this.aCy.aCL.getView()).setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.pos_other_pay_setting_activity);
    getWindow().setFeatureInt(7, R.layout.pos_title);
    setTitleTextView(R.string.pos_pay_type);
    setTitleTextViewRight(R.string.auth_submitButton, this.aCB);
    this.aCy.S(findViewById(this.aCy.getId()));
    wR();
    setListeners();
    this.aCf.initData();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\OtherPaySettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */