package com.laiqian.network.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.laiqian.util.ch;
import java.io.File;
import java.util.HashMap;

public class AppInstallReceiver extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    paramContext.getPackageManager();
    if (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"))
      paramIntent.getData().getSchemeSpecificPart(); 
    if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
      paramIntent.getData().getSchemeSpecificPart(); 
    if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
      paramIntent.getData().getSchemeSpecificPart();
      if (ch.cd(paramContext) > 0.0D)
        (new File(ch.awE())).delete(); 
      HashMap hashMap = ch.K(paramContext, ch.ch(paramContext));
      if (hashMap != null) {
        String str = String.valueOf(hashMap.get("sServerJson"));
        ch.e(paramContext, ch.ch(paramContext), str, "YES");
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\AppInstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */