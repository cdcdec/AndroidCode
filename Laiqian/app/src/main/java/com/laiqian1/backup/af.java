package com.laiqian.backup;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.util.bb;

class af extends Handler {
  af(BackUpToServer paramBackUpToServer) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    String str = (String)paramMessage.obj;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" BackUp result is ");
    stringBuilder.append(str);
    bb.e("_Sync", stringBuilder.toString());
    if (str.equals("1")) {
      Toast.makeText(this.aIz, 2131624317, 1000).show();
    } else {
      Toast.makeText(this.aIz, 2131624318, 1000).show();
    } 
    if (BackUpToServer.a(this.aIz) != null) {
      BackUpToServer.a(this.aIz).dismiss();
      BackUpToServer.a(this.aIz, null);
    } 
    this.aIz.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */