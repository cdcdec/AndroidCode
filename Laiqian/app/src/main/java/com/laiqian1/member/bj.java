package com.laiqian.member;

import android.os.Handler;
import android.os.Message;

class bj extends Handler {
  bj(MemberListActivity paramMemberListActivity) {}
  
  public void handleMessage(Message paramMessage) {
    if (!"".equals(String.valueOf(paramMessage.obj)))
      MemberListActivity.b(this.bvu).setText(String.valueOf(paramMessage.obj)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */