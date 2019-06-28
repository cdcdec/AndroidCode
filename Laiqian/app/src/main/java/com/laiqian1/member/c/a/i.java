package com.laiqian.member.c.a;

import android.widget.Toast;
import com.laiqian.vip.R;

class i implements Runnable {
  i(h paramh) {}
  
  public void run() {
    String str = g.a(this.bxJ.bxI).getString(R.string.connection_timeout_try_again);
    Toast.makeText(g.a(this.bxJ.bxI), str, 1).show();
    g.b(this.bxJ.bxI).dK(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\c\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */