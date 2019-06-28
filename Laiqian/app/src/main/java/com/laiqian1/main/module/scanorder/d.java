package com.laiqian.main.module.scanorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.laiqian.news.aa;

class d extends BroadcastReceiver {
  d(PosActivityScanOrderFragment paramPosActivityScanOrderFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    int i = paramIntent.getIntExtra(aa.bXq, 0);
    PosActivityScanOrderFragment.a(this.blA, i);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\scanorder\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */