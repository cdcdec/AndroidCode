package com.laiqian.pos.settings;

import android.util.Log;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.g;
import com.laiqian.sync.model.SyncProgessMessage;
import kotlin.Metadata;
import kotlin.jvm.b.f;

@Metadata
final class bn implements Runnable {
  bn(ShopDeviceModeSettingFragment paramShopDeviceModeSettingFragment, g paramg) {}
  
  public final void run() {
    SyncProgessMessage syncProgessMessage = this.cBg.apy();
    f.l(syncProgessMessage, "syncManager.syncProgessMessage");
    syncProgessMessage.gW(true);
    this.cBg.a(true, "t_bpartner", a.aOD, System.currentTimeMillis());
    this.cBg.a(false, "t_bpartner_chargedoc", a.aOD, System.currentTimeMillis());
    boolean bool = this.cBg.execute();
    String str = this.cBf.adA();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 离线会员改在线会员后数据上传 success=");
    stringBuilder.append(bool);
    Log.i(str, stringBuilder.toString());
    if (bool) {
      ShopDeviceModeSettingFragment.a(this.cBf).obtainMessage(ShopDeviceModeSettingFragment.b(this.cBf), Boolean.valueOf(bool)).sendToTarget();
      return;
    } 
    ShopDeviceModeSettingFragment.a(this.cBf).obtainMessage(ShopDeviceModeSettingFragment.c(this.cBf), Boolean.valueOf(bool)).sendToTarget();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */