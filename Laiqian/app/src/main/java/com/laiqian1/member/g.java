package com.laiqian.member;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class g extends Handler {
  g(MemberChangeActivity paramMemberChangeActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.what == this.btq.bth)
      Toast.makeText(this.btq, paramMessage.obj.toString(), 0).show(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */