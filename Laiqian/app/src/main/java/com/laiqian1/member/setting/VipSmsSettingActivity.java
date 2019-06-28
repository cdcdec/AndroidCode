package com.laiqian.member.setting;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.laiqian.member.setting.sms.SmsSettingFragment;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.vip.R;

public class VipSmsSettingActivity extends ActivityRoot implements aa {
  private SmsSettingFragment bCV;
  
  private void setupViews() {
    this.bCV = (SmsSettingFragment)getSupportFragmentManager().findFragmentByTag("SmsSettingFragment");
    if (this.bCV == null) {
      this.bCV = SmsSettingFragment.ST();
      FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
      fragmentTransaction.add(this.bCV, "SmsSettingFragment");
      fragmentTransaction.commit();
    } 
  }
  
  public boolean Az() { return false; }
  
  public void a(aa paramaa) {}
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.activity_vip_sms_setting);
    setTitleTextView(R.string.pos_main_setting_sms_setting_title);
    setupViews();
    setTitleTextViewRight(R.string.auth_submitButton, new be(this));
  }
  
  public void save() {
    if (this.bCV != null)
      this.bCV.save(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\VipSmsSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */