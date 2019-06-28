package com.laiqian.scanorder.settings;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.Toast;
import com.laiqian.models.at;
import com.laiqian.sync.a.g;
import io.reactivex.g.a;

class s extends Handler {
  s(PayAndFeeFragment paramPayAndFeeFragment) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 4:
        if (PayAndFeeFragment.d(this.djj).isShowing()) {
          PayAndFeeFragment.d(this.djj).dismiss();
          return;
        } 
        return;
      case 3:
        if (!PayAndFeeFragment.d(this.djj).isShowing()) {
          PayAndFeeFragment.d(this.djj).show();
          return;
        } 
        return;
      case 1:
        PayAndFeeFragment.c(this.djj).obtainMessage(4).sendToTarget();
        PayAndFeeFragment.e(this.djj).show();
        return;
      case 0:
        break;
    } 
    PayAndFeeFragment.c(this.djj).obtainMessage(4).sendToTarget();
    at at = new at(this.djj.getActivity());
    at.ep(true);
    at.close();
    this.djj.getActivity().sendBroadcast(new Intent("pos_activity_change_data_vip_online"));
    ((CheckBox)this.djj.djg.csW.dwV.getView()).setChecked(true);
    this.djj.djh.cE(((CheckBox)this.djj.djg.csW.dwV.getView()).isChecked());
    Toast.makeText(this.djj.getActivity(), "同步成功", 0).show();
    a.aKh().r(new t(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */