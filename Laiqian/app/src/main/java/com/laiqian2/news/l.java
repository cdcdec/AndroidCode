package com.laiqian.news;

import android.content.Intent;
import com.laiqian.basic.RootApplication;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;

class l implements t.f {
  l(k paramk) {}
  
  public void dp(boolean paramBoolean) throws m {
    RootApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_area"));
    NewsActivity.h(this.bWE.bWD.bWC).gr(0);
    NewsActivity.c(this.bWE.bWD.bWC).setEnabled(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */