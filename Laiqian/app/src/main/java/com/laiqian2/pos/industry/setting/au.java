package com.laiqian.pos.industry.setting;

import android.content.Intent;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;

class au implements r.a {
  au(MainSetting paramMainSetting) {}
  
  public void xD() {}
  
  public void xE() {
    av av = new av(this.csj);
    av.hD(true);
    av.close();
    Intent intent = new Intent();
    intent.setClass(this.csj, CrashApplication.aMW);
    this.csj.startActivity(intent);
    this.csj.finish();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */