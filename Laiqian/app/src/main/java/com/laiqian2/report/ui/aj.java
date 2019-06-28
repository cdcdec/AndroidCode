package com.laiqian.report.ui;

import android.os.Handler;
import android.os.Message;

class aj extends Handler {
  aj(OrderDetailsRoot paramOrderDetailsRoot) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (this.dfa.isUseOnlineMember())
      this.dfa.showWaitingDialog(false); 
    switch (paramMessage.what) {
      default:
        return;
      case 101:
        this.dfa.onDeleteFail();
        return;
      case 100:
        break;
    } 
    this.dfa.onDeleteSuc();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */