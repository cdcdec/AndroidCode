package com.laiqian.pos.industry.setting;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class al extends Handler {
  al(MainSetting paramMainSetting) {}
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what == 1) {
      Toast.makeText(this.csj, this.csj.getString(2131628424), 0).show();
    } else {
      Toast.makeText(this.csj, this.csj.getString(2131628422), 0).show();
    } 
    MainSetting.access$900(this.csj);
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */