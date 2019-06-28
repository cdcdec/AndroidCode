package com.laiqian.backup;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.util.av;

class h extends Handler {
  h(BackUpRootActivity paramBackUpRootActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.obj.equals("start")) {
      this.aHq.aHk = ProgressDialog.show(this.aHq, this.aHq.getString(2131624386), this.aHq.getString(2131624355));
      this.aHq.aHk.setCancelable(true);
      return;
    } 
    if (paramMessage.obj.equals("success")) {
      av = new av(this.aHq);
      av.hy(true);
      av.close();
      Toast.makeText(this.aHq, this.aHq.getString(2131624357), 1).show();
      if (this.aHq.aHk != null)
        try {
          this.aHq.aHk.dismiss();
          this.aHq.aHk = null;
        } catch (Exception av) {} 
      BackUpRootActivity.f(this.aHq);
      return;
    } 
    Toast.makeText(this.aHq, (String)av.obj, 1).show();
    if (this.aHq.aHk != null) {
      this.aHq.aHk.dismiss();
      this.aHq.aHk = null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */