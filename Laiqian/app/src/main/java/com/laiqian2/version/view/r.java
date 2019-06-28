package com.laiqian.version.view;

import android.os.Handler;
import android.os.Message;

class r extends Handler {
  r(MyEvaluationActivity paramMyEvaluationActivity) {}
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what == 1)
      this.dKi.finish(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */