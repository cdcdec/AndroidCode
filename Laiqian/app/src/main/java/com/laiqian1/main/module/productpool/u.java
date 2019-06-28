package com.laiqian.main.module.productpool;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

class u extends Handler {
  u(p paramp) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 1)
      p.a.a(p.g(this.bla), (ArrayList)paramMessage.obj); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productpoo\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */