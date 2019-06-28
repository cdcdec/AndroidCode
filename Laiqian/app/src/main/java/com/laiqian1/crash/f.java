package com.laiqian.crash;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class f extends Handler {
  f(e parame) {}
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what != 1) {
      Toast.makeText(CrashList.a.a(this.aMK.aMJ.aMI), CrashList.a.a(this.aMK.aMJ.aMI).getResources().getString(2131624888), 0).show();
    } else {
      Toast.makeText(CrashList.a.a(this.aMK.aMJ.aMI), CrashList.a.a(this.aMK.aMJ.aMI).getResources().getString(2131624889), 0).show();
      this.aMK.aMJ.aMH.setVisibility(8);
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */