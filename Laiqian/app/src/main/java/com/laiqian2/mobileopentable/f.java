package com.laiqian.mobileopentable;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.opentable.R;

class f extends Handler {
  f(OrderResultActivity paramOrderResultActivity) {}
  
  public void handleMessage(Message paramMessage) {
    String str;
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 2:
        OrderResultActivity.d(this.bMm).performClick();
        return;
      case 0:
        OrderResultActivity.e(this.bMm);
        str = this.bMm.getString(R.string.pos_connect_server_timeout_try_again);
        Toast.makeText(this.bMm, str, 1).show();
        break;
      case 1:
        break;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */