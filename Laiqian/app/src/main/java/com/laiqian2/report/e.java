package com.laiqian.report;

import android.os.Handler;
import android.os.Message;

class e extends Handler {
  e(FilterActivity20150320 paramFilterActivity20150320) {}
  
  public void handleMessage(Message paramMessage) {
    if (!"".equals(String.valueOf(paramMessage.obj))) {
      this.cYY.cYR.setText(String.valueOf(paramMessage.obj));
      if (this.cYY.cYR.hasFocus())
        this.cYY.cYR.selectAll(); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */