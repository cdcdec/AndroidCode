package com.laiqian.setting;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.laiqian.util.n;

class cr extends Handler {
  cr(SettingWechatsFragment paramSettingWechatsFragment, Looper paramLooper) { super(paramLooper); }
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 0:
        this.dnw.zM();
        n.eP(2131628564);
        SettingWechatsFragment.a(this.dnw);
        break;
      case 1:
        break;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */