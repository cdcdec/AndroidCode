package com.laiqian.member.setting.sms;

import android.content.Intent;
import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class o implements View.OnClickListener {
  o(SmsSettingFragment paramSmsSettingFragment) {}
  
  public void onClick(View paramView) {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.o(this.bGR.getString(R.string.vip_setting_can_not_edit));
      return;
    } 
    Intent intent = new Intent(this.bGR.getActivity(), BuySmsActivity.class);
    intent.putExtra("SMS_QUANTITY_LEFT", this.bGR.bGP.Su());
    this.bGR.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */