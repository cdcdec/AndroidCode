package com.laiqian.login.view;

import android.text.TextUtils;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.models.m;
import com.laiqian.util.av;
import com.laiqian.util.cc;
import com.laiqian.util.n;

class ab implements Runnable {
  ab(LoginActivity paramLoginActivity) {}
  
  public void run() {
    av av = new av(RootApplication.zv());
    String str1 = av.avP();
    if (TextUtils.isEmpty(str1)) {
      m.UX();
      return;
    } 
    String str2 = a.AZ().Cc();
    if (!TextUtils.isEmpty(str2) && str2.contains("-")) {
      String[] arrayOfString = str2.split("-");
      if (!n.a(arrayOfString[0], arrayOfString[1], Long.parseLong(str1), System.currentTimeMillis()) && a.AZ().BL())
        m.UX(); 
    } 
    av.close();
    cc.ca(this.aZD);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */