package com.laiqian.print;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.laiqian.print.model.s;

class aa extends BroadcastReceiver {
  aa(s params) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    for (byte b = 0; b < s.a(this.cCL).getCount(); b++) {
      s s1 = s.a(this.cCL).hA(b).aew();
      if (s1.getType() == 1)
        s.a(this.cCL, s1); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */