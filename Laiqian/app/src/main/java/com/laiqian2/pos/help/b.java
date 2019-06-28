package com.laiqian.pos.help;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.av;
import com.laiqian.util.az;
import com.laiqian.util.by;

class b extends Handler {
  b(HelpActivity paramHelpActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    String str = (String)paramMessage.obj;
    az.c(getClass(), str);
    av av = new av(this.cmO);
    av.dw(by.parseLong(str));
    av.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\help\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */