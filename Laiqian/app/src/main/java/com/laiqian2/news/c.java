package com.laiqian.news;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class c extends BroadcastReceiver {
  c(NewsActivity paramNewsActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    paramIntent.getIntExtra(aa.bXq, 0);
    if (paramIntent.getBooleanExtra(aa.bXr, false) && NewsActivity.a(this.bWC) == 0)
      NewsActivity.h(this.bWC).gr(0); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */