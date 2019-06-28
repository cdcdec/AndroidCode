package com.laiqian.sync.view;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class w extends Handler {
  w(v paramv) {}
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what != 1) {
      this.dqw.dqv.dqs.kB(paramMessage.arg1);
    } else {
      this.dqw.dqv.dqs.hideProgress();
      Toast.makeText(this.dqw.dqv.getBaseContext(), "测试数据已准备好,请点击同步开始测试", 0).show();
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */