package com.laiqian.opentable.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.util.bd;

public class NetWorkChangeBroadcastReceiver extends BroadcastReceiver {
  public static NetWorkChangeBroadcastReceiver bZj;
  
  public static NetWorkChangeBroadcastReceiver XN() {
    if (bZj == null)
      bZj = new NetWorkChangeBroadcastReceiver(); 
    return bZj;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (a.AZ().Bk() && b.XB()) {
      if (bd.bH(RootApplication.zv())) {
        paramContext.sendBroadcast(new Intent("pos_activity_network_resume"));
        return;
      } 
      paramContext.sendBroadcast(new Intent("pos_activity_network_disconnection"));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\NetWorkChangeBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */