package com.laiqian.setting;

import android.os.Handler;
import android.os.Message;

class i extends Handler {
  i(DateSettingActivity paramDateSettingActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      case 4:
        this.djT.showError(this.djT.getString(2131626516));
        break;
      case 3:
        this.djT.showError(this.djT.getString(2131624345));
        break;
      case 2:
        this.djT.showError(this.djT.getString(2131626678));
        break;
    } 
    if (!this.djT.isFinishing())
      DateSettingActivity.b(this.djT).dismiss(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */