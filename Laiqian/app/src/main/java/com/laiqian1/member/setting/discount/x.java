package com.laiqian.member.setting.discount;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.Toast;
import com.laiqian.models.at;

class x extends Handler {
  x(VipSettingFragment paramVipSettingFragment) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 4:
        if (VipSettingFragment.b(this.bDZ).isShowing()) {
          VipSettingFragment.b(this.bDZ).dismiss();
          return;
        } 
        return;
      case 3:
        if (!VipSettingFragment.b(this.bDZ).isShowing()) {
          VipSettingFragment.b(this.bDZ).show();
          return;
        } 
        return;
      case 1:
        VipSettingFragment.a(this.bDZ).obtainMessage(4).sendToTarget();
        VipSettingFragment.c(this.bDZ).show();
        return;
      case 0:
        break;
    } 
    VipSettingFragment.a(this.bDZ).obtainMessage(4).sendToTarget();
    at at = new at(this.bDZ.getActivity());
    at.ep(true);
    at.close();
    this.bDZ.getActivity().sendBroadcast(new Intent("pos_activity_change_data_vip_online"));
    ((CheckBox)this.bDZ.bDX.bEc.dwV.getView()).setChecked(true);
    Toast.makeText(this.bDZ.getActivity(), "同步成功", 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */