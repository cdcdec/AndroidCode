package com.laiqian.main;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.by;

class am extends Handler {
  am(PosActivity paramPosActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    String str = (String)paramMessage.obj;
    PosActivity.b(this.baU, by.parseInt(str));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */