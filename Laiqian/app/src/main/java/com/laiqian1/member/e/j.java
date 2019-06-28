package com.laiqian.member.e;

import android.util.Log;
import com.laiqian.entity.as;

class j implements a.a {
  j(i parami) {}
  
  public void a(as paramas) {
    (e.a(this.byr.byq.byp)).aWH = paramas;
    if (!(e.a(this.byr.byq.byp)).aWH.isOpen) {
      e.c(this.byr.byq.byp).dj(true);
      this.byr.byq.byp.dismiss();
    } 
    Log.e("onChangeSuccess", (e.a(this.byr.byq.byp)).aWH.password);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */