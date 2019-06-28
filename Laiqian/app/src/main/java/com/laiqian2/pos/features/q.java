package com.laiqian.pos.features;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class q extends Handler {
  q(ScanOrderExportFragment paramScanOrderExportFragment) {}
  
  public void handleMessage(Message paramMessage) {
    if (Boolean.parseBoolean(String.valueOf(paramMessage.obj))) {
      Toast.makeText(ScanOrderExportFragment.f(this.cjQ), 2131626752, 0).show();
      this.cjQ.cjN.dismiss();
    } else {
      Toast.makeText(ScanOrderExportFragment.f(this.cjQ), 2131626749, 0).show();
    } 
    ScanOrderExportFragment.g(this.cjQ).setVisibility(8);
    ScanOrderExportFragment.h(this.cjQ).setVisibility(0);
    ScanOrderExportFragment.e(this.cjQ).setClickable(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */