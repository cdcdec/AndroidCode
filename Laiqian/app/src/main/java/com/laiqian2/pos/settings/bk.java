package com.laiqian.pos.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class bk extends Handler {
  bk(ShopDeviceModeSettingFragment paramShopDeviceModeSettingFragment) {}
  
  public void handleMessage(@NotNull Message paramMessage) {
    f.m(paramMessage, "msg");
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i == ShopDeviceModeSettingFragment.h(this.cBf)) {
      bb bb = ShopDeviceModeSettingFragment.i(this.cBf);
      if (bb == null)
        f.aQI(); 
      if (!bb.isShowing()) {
        bb = ShopDeviceModeSettingFragment.i(this.cBf);
        if (bb == null)
          f.aQI(); 
        bb.show();
        return;
      } 
    } else if (i == ShopDeviceModeSettingFragment.j(this.cBf)) {
      bb bb = ShopDeviceModeSettingFragment.i(this.cBf);
      if (bb == null)
        f.aQI(); 
      if (bb.isShowing()) {
        bb = ShopDeviceModeSettingFragment.i(this.cBf);
        if (bb == null)
          f.aQI(); 
        bb.dismiss();
        return;
      } 
    } else {
      if (i == ShopDeviceModeSettingFragment.b(this.cBf)) {
        obtainMessage(ShopDeviceModeSettingFragment.j(this.cBf)).sendToTarget();
        a a = a.AZ();
        f.l(a, "LQKConfiguration.getInstance()");
        a.bQ(true);
        this.cBf.getActivity().sendBroadcast(new Intent("pos_activity_change_data_vip_online"));
        ShopDeviceModeSettingFragment.e(this.cBf).setSelected(true);
        ShopDeviceModeSettingFragment.f(this.cBf).setSelected(false);
        Toast.makeText((Context)this.cBf.getActivity(), (CharSequence)"同步成功", 0).show();
        return;
      } 
      if (i == ShopDeviceModeSettingFragment.c(this.cBf)) {
        obtainMessage(ShopDeviceModeSettingFragment.j(this.cBf)).sendToTarget();
        r r = ShopDeviceModeSettingFragment.k(this.cBf);
        if (r == null)
          f.aQI(); 
        r.show();
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */