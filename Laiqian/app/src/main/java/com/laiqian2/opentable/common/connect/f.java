package com.laiqian.opentable.common.connect;

import android.content.Intent;
import com.laiqian.basic.RootApplication;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.t;
import io.netty.channel.s;
import io.netty.channel.t;
import io.netty.e.b.v;

final class f implements t {
  f(t.f paramf) {}
  
  public void a(s params) throws Exception {
    if (!params.aEG() || !params.isDone()) {
      if (this.bYi != null)
        this.bYi.dp(false); 
      if (b.XH())
        RootApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_area")); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\connect\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */