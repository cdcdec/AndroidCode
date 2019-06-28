package com.laiqian.opentable.common;

import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.opentable.R;

class ad implements Runnable {
  ad(x paramx, boolean paramBoolean) {}
  
  public void run() {
    if (x.h(this.bZn) != null)
      try {
        x.h(this.bZn).dp(this.bHz);
      } catch (m m) {
        a.e(m);
      }  
    x.i(this.bZn);
    if (this.bHz) {
      this.bZn.dismiss();
      return;
    } 
    String str = x.j(this.bZn).getString(R.string.query_timeout_try_again);
    Toast.makeText(x.j(this.bZn), str, 1).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */