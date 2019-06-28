package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.Toast;
import com.laiqian.models.at;

class gc extends Handler {
  gc(WeshopMarketingFragment paramWeshopMarketingFragment) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 4:
        if (WeshopMarketingFragment.g(this.cwC).isShowing()) {
          WeshopMarketingFragment.g(this.cwC).dismiss();
          return;
        } 
        return;
      case 3:
        if (!WeshopMarketingFragment.g(this.cwC).isShowing()) {
          WeshopMarketingFragment.g(this.cwC).show();
          return;
        } 
        return;
      case 1:
        WeshopMarketingFragment.f(this.cwC).obtainMessage(4).sendToTarget();
        WeshopMarketingFragment.h(this.cwC).show();
        return;
      case 0:
        break;
    } 
    WeshopMarketingFragment.f(this.cwC).obtainMessage(4).sendToTarget();
    at at = new at(this.cwC.getActivity());
    at.ep(true);
    at.close();
    this.cwC.getActivity().sendBroadcast(new Intent("pos_activity_change_data_vip_online"));
    ((CheckBox)this.cwC.cwv.cwO.dwV.getView()).setChecked(true);
    this.cwC.cww.cE(((CheckBox)this.cwC.cwv.cwO.dwV.getView()).isChecked());
    Toast.makeText(this.cwC.getActivity(), "同步成功", 0).show();
    (new Thread(new gd(this))).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */