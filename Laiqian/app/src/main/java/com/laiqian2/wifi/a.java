package com.laiqian.wifi;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.laiqian.util.r;

class a implements Runnable {
  a(WifiDebugFragment paramWifiDebugFragment) {}
  
  public void run() {
    WifiInfo wifiInfo = ((WifiManager)r.E(this.dMq.getActivity(), "wifi")).getConnectionInfo();
    this.dMq.dMp.dMr.setText(String.valueOf(wifiInfo.getRssi()));
    if (WifiDebugFragment.dMo)
      this.dMq.dMp.aQG.postDelayed(this, 300L); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wifi\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */