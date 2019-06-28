package com.laiqian.member.setting;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.models.at;

class al extends Handler {
  al(VipModeSettingActivity paramVipModeSettingActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 4:
        if (VipModeSettingActivity.a(this.bCH).isShowing()) {
          VipModeSettingActivity.a(this.bCH).dismiss();
          return;
        } 
        return;
      case 3:
        if (!VipModeSettingActivity.a(this.bCH).isShowing()) {
          VipModeSettingActivity.a(this.bCH).show();
          return;
        } 
        return;
      case 1:
        VipModeSettingActivity.b(this.bCH).obtainMessage(4).sendToTarget();
        VipModeSettingActivity.d(this.bCH).show();
        return;
      case 0:
        break;
    } 
    VipModeSettingActivity.b(this.bCH).obtainMessage(4).sendToTarget();
    at at = new at(this.bCH.getActivity());
    at.ep(true);
    at.close();
    this.bCH.getActivity().sendBroadcast(new Intent("pos_activity_change_data_vip_online"));
    VipModeSettingActivity.c(this.bCH).setChecked(true);
    VipModeSettingActivity.c(this.bCH).aqT().setEnabled(false);
    Toast.makeText(this.bCH.getActivity(), "同步成功", 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */