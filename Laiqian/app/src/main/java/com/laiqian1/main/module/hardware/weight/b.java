package com.laiqian.main.module.hardware.weight;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbManager;
import android.util.Pair;
import com.laiqian.d.a;
import com.laiqian.scales.b.c;

class b extends BroadcastReceiver {
  b(PosActivityScaleFragment paramPosActivityScaleFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    paramIntent.getAction().hashCode();
    if (a.AZ().BE()) {
      PosActivityScaleFragment.a(this.bgp);
      Pair pair = PosActivityScaleFragment.b(this.bgp);
      PosActivityScaleFragment.a(this.bgp, (c)pair.first, (UsbManager)pair.second);
      PosActivityScaleFragment.c(this.bgp);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\hardware\weight\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */