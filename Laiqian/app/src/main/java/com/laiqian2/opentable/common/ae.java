package com.laiqian.opentable.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.opentable.R;

class ae extends Handler {
  ae(x paramx, Looper paramLooper) { super(paramLooper); }
  
  public void handleMessage(Message paramMessage) {
    String str;
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 0:
        x.i(this.bZn);
        str = x.j(this.bZn).getString(R.string.query_timeout_try_again);
        Toast.makeText(x.j(this.bZn), str, 1).show();
        break;
      case 1:
        break;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */