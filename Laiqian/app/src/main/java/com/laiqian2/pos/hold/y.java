package com.laiqian.pos.hold;

import android.content.Intent;
import com.laiqian.util.n;

class y implements Runnable {
  y(OpenTableSettingActivity paramOpenTableSettingActivity, boolean paramBoolean) {}
  
  public void run() {
    n.o(this.coe.getString(2131628160));
    this.coe.sendBroadcast(new Intent("pos_shut_down"));
    if (this.cof)
      this.coe.finish(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */