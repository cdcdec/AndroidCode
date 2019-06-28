package com.laiqian.member.setting;

import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.at;
import com.laiqian.network.o;
import com.laiqian.pos.settings.aa;
import com.laiqian.sync.a.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.LayoutLeftTextRightCheckboxOnlineMemberSwitch;
import com.laiqian.ui.container.aa;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.concurrent.FutureTask;

public class VipModeSettingActivity extends ActivityRoot implements aa {
  private LayoutLeftTextRightCheckboxOnlineMemberSwitch bCC;
  
  private TextView bCD;
  
  private r bCE;
  
  private r bCF;
  
  private Handler mHandler = new al(this);
  
  private bb mWaitingDialog;
  
  private void JZ() {
    if (this.bCC.aqT().isChecked())
      this.bCC.aqT().setClickable(false); 
    this.bCC.setOnCheckedChangeListener(new ak(this));
    this.bCF.a(new an(this));
    this.bCE.a(new ao(this));
  }
  
  private void RD() {
    this.mHandler.obtainMessage(3).sendToTarget();
    try {
      g g = new g(getActivity());
      o.WQ().a(new FutureTask(new am(this, g), null));
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
  
  private void initData() {
    setTitleTextViewRight(R.string.auth_submitButton, new ap(this));
    at at = new at(this);
    boolean bool = at.Wq();
    at.close();
    this.bCC.setChecked(bool);
  }
  
  private void setupViews() {
    this.bCC = (LayoutLeftTextRightCheckboxOnlineMemberSwitch)findViewById(R.id.vip_mode_setting);
    this.bCC.oW(getString(R.string.member_online_switch));
    this.bCD = (TextView)findViewById(R.id.vip_mode_setting_hint);
    String str = getString(R.string.member_mode_setting_hint);
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("多台收银机或使用线上会员的门店推荐开启在线会员，以保证余额准确一致");
    spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red_color_10500)), str.indexOf("多台收银机"), str.indexOf("多台收银机") + 5, 33);
    spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red_color_10500)), str.indexOf("线上会员"), str.indexOf("线上会员") + 4, 33);
    this.bCD.setText(spannableStringBuilder);
  }
  
  public boolean Az() { return false; }
  
  public void a(aa paramaa) {}
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.activity_vip_mode_setting);
    setTitleTextView(R.string.member_mode_setting);
    setupViews();
    initData();
    RE();
    JZ();
  }
  
  public void save() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\VipModeSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */