package com.laiqian.report.ui;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.n;

class ce extends Handler {
  ce(ShiftDetails paramShiftDetails) {}
  
  private void aot() {
    ShiftDetails.a(this.dhh).setVisibility(0);
    ShiftDetails.b(this.dhh).setVisibility(4);
  }
  
  public void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      case 99:
        n.w(this.dhh, 2131627422);
        aot();
        break;
      case 98:
        n.a(this.dhh, "你的设置有问题");
        aot();
        break;
      case 97:
        n.w(this.dhh, 2131627420);
        aot();
        break;
    } 
    this.dhh.dgk = false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */