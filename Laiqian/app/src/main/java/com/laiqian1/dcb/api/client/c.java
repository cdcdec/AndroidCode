package com.laiqian.dcb.api.client;

import android.os.Handler;
import android.os.Message;
import io.reactivex.g.a;

class c extends Handler {
  c(ClientService paramClientService) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.obj.equals(Boolean.valueOf(true)))
      a.aKh().r(new d(this)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\client\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */