package com.laiqian.promotion.d;

import android.os.Handler;
import android.os.Message;
import java.util.List;

class g extends Handler {
  g(e parame) {}
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what != 1)
      return; 
    e.a(this.cVW).P((List)paramMessage.obj);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */