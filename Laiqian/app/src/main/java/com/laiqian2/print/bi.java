package com.laiqian.print;

import android.util.Log;
import com.laiqian.print.model.d;
import com.laiqian.print.model.q;

class bi implements d.a {
  bi(be parambe) {}
  
  public void aeV() {
    Log.i("tag", "net session complete");
    if ((be.f(this.cDX) & 0x4) != 0 && this.cDX.cDJ != null) {
      Log.i("tag", "starting bluetooth session");
      this.cDX.cDJ.start();
      return;
    } 
    be.e(this.cDX).aeV();
  }
  
  public void aeW() { be.e(this.cDX).aeW(); }
  
  public void aeX() { be.e(this.cDX).aeX(); }
  
  public void l(q paramq) { be.e(this.cDX).l(paramq); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */