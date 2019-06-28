package com.laiqian.mobileopentable;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class d extends Handler {
  d(OrderResultActivity paramOrderResultActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    Toast.makeText(this.bMm, paramMessage.obj.toString(), 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */