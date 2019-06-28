package com.laiqian.member.c.a;

import android.app.Activity;
import java.util.TimerTask;

class h extends TimerTask {
  h(g paramg) {}
  
  public void run() {
    if (g.a(this.bxI) instanceof Activity)
      ((Activity)g.a(this.bxI)).runOnUiThread(new i(this)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\c\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */