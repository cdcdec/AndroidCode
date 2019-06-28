package com.laiqian.member.e;

import android.util.Log;
import com.laiqian.entity.as;

class k implements a.a {
  k(h paramh) {}
  
  public void a(as paramas) {
    (e.a(this.byq.byp)).aWH = paramas;
    if (!(e.a(this.byq.byp)).aWH.isOpen) {
      e.c(this.byq.byp).dj(true);
      this.byq.byp.dismiss();
    } 
    Log.e("onChangeSuccess", (e.a(this.byq.byp)).aWH.password);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\e\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */