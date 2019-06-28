package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.Toast;
import com.laiqian.models.at;

class t extends Handler {
  t(QrorderMarketingFragment paramQrorderMarketingFragment) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 4:
        if (QrorderMarketingFragment.d(this.csM).isShowing()) {
          QrorderMarketingFragment.d(this.csM).dismiss();
          return;
        } 
        return;
      case 3:
        if (!QrorderMarketingFragment.d(this.csM).isShowing()) {
          QrorderMarketingFragment.d(this.csM).show();
          return;
        } 
        return;
      case 1:
        QrorderMarketingFragment.c(this.csM).obtainMessage(4).sendToTarget();
        QrorderMarketingFragment.e(this.csM).show();
        return;
      case 0:
        break;
    } 
    QrorderMarketingFragment.c(this.csM).obtainMessage(4).sendToTarget();
    at at = new at(this.csM.getActivity());
    at.ep(true);
    at.close();
    this.csM.getActivity().sendBroadcast(new Intent("pos_activity_change_data_vip_online"));
    ((CheckBox)this.csM.csK.csW.dwV.getView()).setChecked(true);
    this.csM.csL.eY(((CheckBox)this.csM.csK.csW.dwV.getView()).isChecked());
    Toast.makeText(this.csM.getActivity(), "同步成功", 0).show();
    (new Thread(new u(this))).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */