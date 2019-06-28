package com.laiqian.opentable.pos;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.opentable.R;

class q extends Handler {
  q(j paramj, Looper paramLooper) { super(paramLooper); }
  
  public void handleMessage(Message paramMessage) {
    String str;
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 0:
        this.cbg.zM();
        str = j.a(this.cbg).getString(R.string.query_timeout_try_again);
        Toast.makeText(j.a(this.cbg), str, 1).show();
        break;
      case 1:
        break;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */